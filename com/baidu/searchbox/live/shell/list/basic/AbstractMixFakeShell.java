package com.baidu.searchbox.live.shell.list.basic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.api.IExtLifecycle;
import com.baidu.live.arch.api.IService;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bV\u0010WJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010\u001eJ\u000f\u0010$\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010\u001eJ'\u0010'\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001aH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010+J'\u0010,\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001aH\u0016¢\u0006\u0004\b,\u0010(J/\u00102\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J%\u00106\u001a\u00020\u00102\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002040\u00072\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020\u00102\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002040\u0007¢\u0006\u0004\b8\u00109R\u0019\u0010;\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010F\u001a\u00020A8D@\u0004X\u0084\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010H\u001a\u00020G8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0019\u0010M\u001a\u00020L8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR1\u0010U\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002040\u0007\u0012\u0004\u0012\u0002040Q8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010C\u001a\u0004\bS\u0010T¨\u0006X"}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "Lcom/baidu/live/arch/api/IExtLifecycle;", "Landroid/view/View;", "createContainerView", "()Landroid/view/View;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getService", "(Ljava/lang/Class;)Ljava/lang/Object;", "", GroupInfoActivityConfig.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onLiveAttach", "()V", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "onLiveBindData", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onLiveDeselected", "onLiveDetach", CriusAttrConstants.POSITION, "isFromUser", "onLiveSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", "onPageSelected", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/baidu/live/arch/api/IService;", "service", "registerServices", "(Ljava/lang/Class;Lcom/baidu/live/arch/api/IService;)V", "unregisterServices", "(Ljava/lang/Class;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "isActive", "Z", "Lcom/baidu/searchbox/live/widget/LiveContainer;", "liveContainer$delegate", "Lkotlin/Lazy;", "getLiveContainer", "()Lcom/baidu/searchbox/live/widget/LiveContainer;", "liveContainer", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "getMixActivity", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "Landroidx/collection/SimpleArrayMap;", "serviceLocator$delegate", "getServiceLocator", "()Landroidx/collection/SimpleArrayMap;", "serviceLocator", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class AbstractMixFakeShell implements IExtLifecycle {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public boolean isActive;
    public final Lazy liveContainer$delegate;
    public final IMixActivityInterface mixActivity;
    public final MiniUniqueId mixUniqueId;
    public final Lazy serviceLocator$delegate;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1647517616, "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1647517616, "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbstractMixFakeShell.class), "serviceLocator", "getServiceLocator()Landroidx/collection/SimpleArrayMap;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbstractMixFakeShell.class), "liveContainer", "getLiveContainer()Lcom/baidu/searchbox/live/widget/LiveContainer;"))};
    }

    private final SimpleArrayMap getServiceLocator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Lazy lazy = this.serviceLocator$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (SimpleArrayMap) lazy.getValue();
        }
        return (SimpleArrayMap) invokeV.objValue;
    }

    public abstract View createContainerView();

    public final LiveContainer getLiveContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Lazy lazy = this.liveContainer$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (LiveContainer) lazy.getValue();
        }
        return (LiveContainer) invokeV.objValue;
    }

    public AbstractMixFakeShell(Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, miniUniqueId, iMixActivityInterface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = context;
        this.mixUniqueId = miniUniqueId;
        this.mixActivity = iMixActivityInterface;
        this.serviceLocator$delegate = LazyKt__LazyJVMKt.lazy(AbstractMixFakeShell$serviceLocator$2.INSTANCE);
        this.liveContainer$delegate = LazyKt__LazyJVMKt.lazy(new AbstractMixFakeShell$liveContainer$2(this));
    }

    public void onLiveSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), liveItemModel, Boolean.valueOf(z)}) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onLiveSelected " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.context;
        }
        return (Context) invokeV.objValue;
    }

    public final IMixActivityInterface getMixActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mixActivity;
        }
        return (IMixActivityInterface) invokeV.objValue;
    }

    public final MiniUniqueId getMixUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mixUniqueId;
        }
        return (MiniUniqueId) invokeV.objValue;
    }

    public Object getService(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            Object obj = getServiceLocator().get(cls);
            if (!(obj instanceof Object)) {
                return null;
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public final void unregisterServices(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cls) == null) {
            getServiceLocator().remove(cls);
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onActivityResult " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048592, this, i, strArr, iArr) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onRequestPermissionsResult " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, configuration) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onConfigurationChanged " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    public void onLiveBindData(LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, liveItemModel) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onLiveBindData " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onNewIntent " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onKeyDown " + getClass().getSimpleName() + " this:" + hashCode());
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void onLiveAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onLiveAttach " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    public void onLiveDeselected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onLiveDeselected " + getClass().getSimpleName() + " this:" + hashCode());
        }
    }

    public void onLiveDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onLiveDetach " + getClass().getSimpleName() + " this:" + hashCode());
            this.isActive = false;
        }
    }

    public void onPageSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), liveItemModel, Boolean.valueOf(z)}) == null) {
            ListLogKt.log(MixTagConstants.MIX_BASE_LIVE, "BaseCell onSelected " + getClass().getSimpleName() + " pos:" + i + " model:" + liveItemModel.getRoomId() + " name:" + liveItemModel.getTitle() + " this:" + hashCode() + WebvttCueParser.CHAR_SPACE);
            if (!this.isActive) {
                this.isActive = true;
                onLiveSelected(i, liveItemModel, z);
            }
        }
    }

    public final void registerServices(Class cls, IService iService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, cls, iService) == null) {
            getServiceLocator().put(cls, iService);
        }
    }
}
