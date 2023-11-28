package com.baidu.spswitch.utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.adapter.EmotionScrollerVPAdapter;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.spswitch.emotion.net.EmotionUrlConfig;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.spswitch.emotion.view.EmotionTabLayout;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BDEmotionPanelManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLOR_EMOTION_TYPE_LAYOUT = -657931;
    public static final int COLOR_EMOTION_TYPE_PLACEHOLDER = -1;
    public static final boolean DEBUG;
    public static final int NIGHT_COLOR_EMOTION_TYPE_LAYOUT = -13421773;
    public static final int NIGHT_COLOR_EMOTION_TYPE_PLACEHOLDER = -14540254;
    public static final String TAG = "BDEmotionPanelManager";
    public static volatile BDEmotionPanelManager sInstance;
    public static Handler sMainHandler;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isNightMode;
    public String mLastStackInfo;

    /* loaded from: classes4.dex */
    public interface OnDynamicEmotionClickListener {
        void onEmotionClick(EmotionItemModel emotionItemModel);
    }

    /* loaded from: classes4.dex */
    public interface OnEmotionClickListener {
        void onEmotionClick(EmotionType emotionType, int i, String str, String str2);
    }

    /* loaded from: classes4.dex */
    public interface OnVerticalEmotionListener {
        public static final int SECTION_TYPE_ALL = 1;
        public static final int SECTION_TYPE_OFTEN = 0;

        void onVerticalEmotionClick(EmotionType emotionType, int i, String str, String str2, int i2, int i3);

        void onVerticalEmotionLongClick(EmotionType emotionType, int i, String str, String str2, int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public interface OnVerticalSendListener {
        boolean isSendEnabled();

        void onClick();
    }

    /* loaded from: classes4.dex */
    public static class EmotionPanelConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Drawable backgroundDrawable;
        public int delBtnColor;
        public Drawable delBtnDrawable;
        public String from;
        public String nid;
        public String page;
        public boolean showDynamicTab;
        public boolean showSendBtn;
        public String source;

        public EmotionPanelConfig(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delBtnColor = ContextCompat.getColor(AppRuntime.getAppContext(), R.color.obfuscated_res_0x7f06026d);
            this.delBtnDrawable = ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.emotion_delete);
            this.showDynamicTab = z;
        }

        public EmotionPanelConfig(boolean z, String str, String str2, String str3, String str4, boolean z2, Drawable drawable, @ColorInt int i, Drawable drawable2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str, str2, str3, str4, Boolean.valueOf(z2), drawable, Integer.valueOf(i), drawable2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.delBtnColor = ContextCompat.getColor(AppRuntime.getAppContext(), R.color.obfuscated_res_0x7f06026d);
            this.delBtnDrawable = ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.emotion_delete);
            this.showDynamicTab = z;
            this.nid = str;
            this.from = str2;
            this.page = str3;
            this.source = str4;
            this.showSendBtn = z2;
            this.backgroundDrawable = drawable;
            this.delBtnColor = i;
            this.delBtnDrawable = drawable2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1438892391, "Lcom/baidu/spswitch/utils/BDEmotionPanelManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1438892391, "Lcom/baidu/spswitch/utils/BDEmotionPanelManager;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
        sMainHandler = new Handler(Looper.getMainLooper());
    }

    public BDEmotionPanelManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BDEmotionPanelManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (sInstance == null) {
                synchronized (BDEmotionPanelManager.class) {
                    if (sInstance == null) {
                        sInstance = new BDEmotionPanelManager();
                    }
                }
            }
            return sInstance;
        }
        return (BDEmotionPanelManager) invokeV.objValue;
    }

    public boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isNightMode;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLoadInnerEmotionPanel(Activity activity, ViewGroup viewGroup, View view2, boolean z, @NonNull EmotionPanelConfig emotionPanelConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{activity, viewGroup, view2, Boolean.valueOf(z), emotionPanelConfig}) == null) {
            if (!(viewGroup instanceof SPSwitchPanelLinearLayout)) {
                if (!DEBUG) {
                    return;
                }
                throw new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout");
            } else if (!(view2 instanceof EditText)) {
                if (!DEBUG) {
                    return;
                }
                throw new IllegalArgumentException("focus view must be EditText");
            } else if (!(activity instanceof FragmentActivity)) {
                if (!DEBUG) {
                    return;
                }
                throw new IllegalArgumentException("host activity must be fragment activity");
            } else {
                this.isNightMode = z;
                handleEmotionTypeLayoutNightMode(viewGroup, emotionPanelConfig.showDynamicTab);
                ViewPager viewPager = (ViewPager) viewGroup.findViewById(R.id.vp_emotion_type);
                GlobalOnItemClickListenerManager.getInstance().attachToEditText((EditText) view2);
                BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = new BDEmotionBagVerticalLayout(AppRuntime.getAppContext(), emotionPanelConfig);
                bDEmotionBagVerticalLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.dip2px(AppRuntime.getAppContext(), 260.0f)));
                bDEmotionBagVerticalLayout.setEmotionList(EmotionUtils.getInstance().getPanelEmotionList());
                ArrayList arrayList = new ArrayList();
                arrayList.add(bDEmotionBagVerticalLayout);
                EmotionScrollerVPAdapter emotionScrollerVPAdapter = new EmotionScrollerVPAdapter(arrayList);
                if (emotionPanelConfig.showDynamicTab) {
                    EmotionTabLayout emotionTabLayout = (EmotionTabLayout) viewGroup.findViewById(R.id.emotion_type_tab_layout);
                    emotionTabLayout.setVisibility(0);
                    if (!DeviceUtils.ScreenInfo.isScreenLand()) {
                        emotionTabLayout.setViewPager(viewPager);
                        viewPager.addOnPageChangeListener(emotionTabLayout.getListener());
                        new BdEmotionDynamicPanelProxy(activity, emotionScrollerVPAdapter, emotionPanelConfig).setTabLayout(emotionTabLayout);
                    } else {
                        viewGroup.findViewById(R.id.emotion_type_layout).setVisibility(8);
                    }
                }
                viewPager.setAdapter(emotionScrollerVPAdapter);
            }
        }
    }

    private FragmentManager getFragmentManager(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, fragmentActivity)) == null) {
            List<Fragment> fragments = fragmentActivity.getSupportFragmentManager().getFragments();
            for (Fragment fragment : fragments) {
                if (fragment.getView() != null && fragment.getView().findViewById(R.id.vp_emotion_type) != null) {
                    return fragment.getChildFragmentManager();
                }
            }
            if (fragmentActivity.findViewById(R.id.vp_emotion_type) != null) {
                return fragmentActivity.getSupportFragmentManager();
            }
            if (DEBUG) {
                StringBuilder sb = new StringBuilder("emotion panel root layout[id:vp_emotion_type] not found, please recheck:\n");
                sb.append("Activity: " + fragmentActivity + "\n");
                if (fragments != null) {
                    sb.append("Fragments: " + fragments + "\n");
                }
                sb.append("stack:\n");
                sb.append(this.mLastStackInfo);
                Log.d(TAG, sb.toString());
            }
            return fragmentActivity.getSupportFragmentManager();
        }
        return (FragmentManager) invokeL.objValue;
    }

    private void handleEmotionTypeLayoutNightMode(ViewGroup viewGroup, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, this, viewGroup, z) == null) {
            View findViewById = viewGroup.findViewById(R.id.emotion_type_tab_layout);
            View findViewById2 = viewGroup.findViewById(R.id.emotion_type_layout);
            findViewById2.setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), R.color.obfuscated_res_0x7f060218));
            int i2 = 0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById2.setVisibility(i);
            if (!z) {
                i2 = 8;
            }
            findViewById.setVisibility(i2);
            viewGroup.findViewById(R.id.emotion_type_divider).setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), R.color.obfuscated_res_0x7f060219));
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GlobalOnItemClickListenerManager.getInstance().dismiss();
            HttpManager.getDefault(AppRuntime.getAppContext()).cancelTag(EmotionUrlConfig.EMO_ID_LIST_TAG);
            HttpManager.getDefault(AppRuntime.getAppContext()).cancelTag(EmotionUrlConfig.EMO_LIST_TAG);
            sInstance = null;
            EmotionUtils.getInstance().freeEmotionSound();
        }
    }

    @Deprecated
    public void loadInnerEmotionPanel(Activity activity, ViewGroup viewGroup, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, viewGroup, view2, Boolean.valueOf(z)}) == null) {
            if (DEBUG) {
                this.mLastStackInfo = Log.getStackTraceString(new Exception());
            }
            sMainHandler.post(new Runnable(this, activity, viewGroup, view2, z) { // from class: com.baidu.spswitch.utils.BDEmotionPanelManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionPanelManager this$0;
                public final /* synthetic */ Activity val$activity;
                public final /* synthetic */ View val$focusView;
                public final /* synthetic */ boolean val$isNightMode;
                public final /* synthetic */ ViewGroup val$panelLayout;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, viewGroup, view2, Boolean.valueOf(z)};
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
                    this.val$activity = activity;
                    this.val$panelLayout = viewGroup;
                    this.val$focusView = view2;
                    this.val$isNightMode = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doLoadInnerEmotionPanel(this.val$activity, this.val$panelLayout, this.val$focusView, this.val$isNightMode, new EmotionPanelConfig(false));
                    }
                }
            });
        }
    }

    public void loadInnerEmotionPanel(Activity activity, ViewGroup viewGroup, View view2, boolean z, EmotionPanelConfig emotionPanelConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, viewGroup, view2, Boolean.valueOf(z), emotionPanelConfig}) == null) {
            if (DEBUG) {
                this.mLastStackInfo = Log.getStackTraceString(new Exception());
            }
            if (emotionPanelConfig == null) {
                emotionPanelConfig = new EmotionPanelConfig(false);
            }
            sMainHandler.post(new Runnable(this, activity, viewGroup, view2, z, emotionPanelConfig) { // from class: com.baidu.spswitch.utils.BDEmotionPanelManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionPanelManager this$0;
                public final /* synthetic */ Activity val$activity;
                public final /* synthetic */ EmotionPanelConfig val$finalConfig;
                public final /* synthetic */ View val$focusView;
                public final /* synthetic */ boolean val$isNightMode;
                public final /* synthetic */ ViewGroup val$panelLayout;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, viewGroup, view2, Boolean.valueOf(z), emotionPanelConfig};
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
                    this.val$activity = activity;
                    this.val$panelLayout = viewGroup;
                    this.val$focusView = view2;
                    this.val$isNightMode = z;
                    this.val$finalConfig = emotionPanelConfig;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doLoadInnerEmotionPanel(this.val$activity, this.val$panelLayout, this.val$focusView, this.val$isNightMode, this.val$finalConfig);
                    }
                }
            });
        }
    }

    public void setOnDynamicEmotionClickListener(OnDynamicEmotionClickListener onDynamicEmotionClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onDynamicEmotionClickListener) == null) {
            GlobalOnItemClickListenerManager.getInstance().setOnDynamicEmotionClickListener(onDynamicEmotionClickListener);
        }
    }

    public void setOnEmotionClickListener(OnEmotionClickListener onEmotionClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onEmotionClickListener) == null) {
            GlobalOnItemClickListenerManager.getInstance().setOnEmotionClickListener(onEmotionClickListener);
        }
    }

    public void setOnVerticalEmotionListener(OnVerticalEmotionListener onVerticalEmotionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onVerticalEmotionListener) == null) {
            GlobalOnItemClickListenerManager.getInstance().setOnVerticalEmotionListener(onVerticalEmotionListener);
        }
    }

    public void setOnVerticalSendBtnClickListener(@Nullable OnVerticalSendListener onVerticalSendListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onVerticalSendListener) == null) {
            GlobalOnItemClickListenerManager.getInstance().setOnVerticalSendBtnClick(onVerticalSendListener);
        }
    }
}
