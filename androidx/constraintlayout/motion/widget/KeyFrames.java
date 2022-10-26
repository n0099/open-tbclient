package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class KeyFrames {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    public static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Integer, ArrayList<Key>> mFramesMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-67713002, "Landroidx/constraintlayout/motion/widget/KeyFrames;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-67713002, "Landroidx/constraintlayout/motion/widget/KeyFrames;");
                return;
            }
        }
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "unable to load", e);
        }
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Key key;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xmlPullParser};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFramesMap = new HashMap<>();
        Key key2 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (sKeyMakers.containsKey(name)) {
                        try {
                            key = sKeyMakers.get(name).newInstance(new Object[0]);
                        } catch (Exception e2) {
                            key = key2;
                            e = e2;
                        }
                        try {
                            key.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(key);
                        } catch (Exception e3) {
                            e = e3;
                            Log.e(TAG, "unable to create ", e);
                            key2 = key;
                            continue;
                            eventType = xmlPullParser.next();
                        }
                        key2 = key;
                        continue;
                    } else if (name.equalsIgnoreCase("CustomAttribute") && key2 != null && key2.mCustomConstraints != null) {
                        ConstraintAttribute.parse(context, xmlPullParser, key2.mCustomConstraints);
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }

    private void addKey(Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, key) == null) {
            if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
                this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList<>());
            }
            this.mFramesMap.get(Integer.valueOf(key.mTargetId)).add(key);
        }
    }

    public static String name(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, context)) == null) {
            return context.getResources().getResourceEntryName(i);
        }
        return (String) invokeIL.objValue;
    }

    public void addFrames(MotionController motionController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionController) == null) {
            ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
            if (arrayList != null) {
                motionController.addKeys(arrayList);
            }
            ArrayList<Key> arrayList2 = this.mFramesMap.get(-1);
            if (arrayList2 != null) {
                Iterator<Key> it = arrayList2.iterator();
                while (it.hasNext()) {
                    Key next = it.next();
                    if (next.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                        motionController.addKey(next);
                    }
                }
            }
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.mFramesMap.get(Integer.valueOf(i));
        }
        return (ArrayList) invokeI.objValue;
    }

    public Set<Integer> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFramesMap.keySet();
        }
        return (Set) invokeV.objValue;
    }
}
