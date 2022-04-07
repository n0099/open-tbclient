package com.baidu.searchbox.v8engine.event;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class EventTargetImpl implements EventTarget {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String EVENT_TYPE = "type";
    public static final String TAG = "EventTargetImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public JSRuntime mJSRuntime;
    public final Lock mLock;
    public Map<String, List<JsFunction>> mTargets;

    public EventTargetImpl(JSRuntime jSRuntime) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new ReentrantLock();
        this.mJSRuntime = jSRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<JsFunction> getEventListeners(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            List<JsFunction> list = getTargetMap().get(str);
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeL.objValue;
    }

    private boolean isArgumentsInvalid(String str, JsFunction jsFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, jsFunction)) == null) ? TextUtils.isEmpty(str) || jsFunction == null : invokeLL.booleanValue;
    }

    private String parseEventType(JsObject jsObject) {
        InterceptResult invokeL;
        int propertyIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, jsObject)) == null) {
            if (jsObject != null && (propertyIndex = jsObject.getPropertyIndex("type")) >= 0) {
                return jsObject.toString(propertyIndex);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public void addEventListener(String str, JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, jsFunction) == null) || isArgumentsInvalid(str, jsFunction)) {
            return;
        }
        try {
            this.mLock.lock();
            List<JsFunction> eventListeners = getEventListeners(str);
            if (!eventListeners.contains(jsFunction)) {
                jsFunction.setReleaseMode(false);
                eventListeners.add(jsFunction);
            }
            if (!getTargetMap().containsKey(str)) {
                getTargetMap().put(str, eventListeners);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSEvent)) == null) {
            if (JSEvent.isValid(jSEvent)) {
                this.mJSRuntime.runOnJSThread(new Runnable(this, jSEvent) { // from class: com.baidu.searchbox.v8engine.event.EventTargetImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EventTargetImpl this$0;
                    public final /* synthetic */ JSEvent val$jsEvent;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jSEvent};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$jsEvent = jSEvent;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                try {
                                    this.this$0.mLock.lock();
                                    for (JsFunction jsFunction : new ArrayList(this.this$0.getEventListeners(this.val$jsEvent.type))) {
                                        if (jsFunction != null) {
                                            jsFunction.call(this.this$0, this.val$jsEvent.data, false);
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } finally {
                                this.this$0.mLock.unlock();
                            }
                        }
                    }
                });
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Map<String, List<JsFunction>> getTargetMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mTargets == null) {
                this.mTargets = new TreeMap();
            }
            return this.mTargets;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    public boolean hasEventListener(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            if (strArr == null) {
                return false;
            }
            try {
                this.mLock.lock();
                for (String str : strArr) {
                    if (getTargetMap().containsKey(str) && !getTargetMap().get(str).isEmpty()) {
                        this.mLock.unlock();
                        return true;
                    }
                }
                return false;
            } finally {
                this.mLock.unlock();
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public void removeEventListener(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            removeEventListener(str, null);
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public void removeEventListener(String str, JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, jsFunction) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.mLock.lock();
            if (jsFunction == null) {
                List<JsFunction> eventListeners = getEventListeners(str);
                if (eventListeners != null) {
                    while (!eventListeners.isEmpty()) {
                        JsFunction jsFunction2 = eventListeners.get(0);
                        eventListeners.remove(jsFunction2);
                        jsFunction2.release();
                    }
                    if (eventListeners.isEmpty() && getTargetMap().containsKey(str)) {
                        getTargetMap().remove(str);
                    }
                }
            } else {
                List<JsFunction> eventListeners2 = getEventListeners(str);
                if (eventListeners2 != null && eventListeners2.contains(jsFunction)) {
                    eventListeners2.remove(jsFunction);
                    jsFunction.release();
                    if (eventListeners2.isEmpty() && getTargetMap().containsKey(str)) {
                        getTargetMap().remove(str);
                    }
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTarget
    @JavascriptInterface
    public boolean dispatchEvent(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject)) == null) {
            String parseEventType = parseEventType(jsObject);
            if (TextUtils.isEmpty(parseEventType)) {
                return false;
            }
            this.mJSRuntime.runOnJSThread(new Runnable(this, parseEventType, jsObject) { // from class: com.baidu.searchbox.v8engine.event.EventTargetImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EventTargetImpl this$0;
                public final /* synthetic */ JsObject val$event;
                public final /* synthetic */ String val$eventType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, parseEventType, jsObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$eventType = parseEventType;
                    this.val$event = jsObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            try {
                                this.this$0.mLock.lock();
                                for (JsFunction jsFunction : new ArrayList(this.this$0.getEventListeners(this.val$eventType))) {
                                    if (jsFunction != null) {
                                        jsFunction.call(this.this$0, this.val$event, false);
                                    }
                                }
                                this.val$event.release();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } finally {
                            this.this$0.mLock.unlock();
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
