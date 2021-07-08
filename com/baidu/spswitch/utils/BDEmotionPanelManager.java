package com.baidu.spswitch.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.adapter.NoHorizontalScrollerVPAdapter;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public interface OnEmotionClickListener {
        void onEmotionClick(EmotionType emotionType, int i2, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface OnVerticalEmotionListener {
        public static final int SECTION_TYPE_ALL = 1;
        public static final int SECTION_TYPE_OFTEN = 0;

        void onVerticalEmotionClick(EmotionType emotionType, int i2, String str, String str2, int i3, int i4);

        void onVerticalEmotionLongClick(EmotionType emotionType, int i2, String str, String str2, int i3, int i4);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLoadInnerEmotionPanel(Activity activity, ViewGroup viewGroup, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{activity, viewGroup, view, Boolean.valueOf(z)}) == null) {
            if (!(viewGroup instanceof SPSwitchPanelLinearLayout)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout");
                }
            } else if (!(view instanceof EditText)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("focus view must be EditText");
                }
            } else if (!(activity instanceof FragmentActivity)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("host activity must be fragment activity");
                }
            } else {
                this.isNightMode = z;
                handleEmotionTypeLayoutNightMode(viewGroup);
                GlobalOnItemClickListenerManager.getInstance().attachToEditText((EditText) view);
                BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = new BDEmotionBagVerticalLayout(AppRuntime.getAppContext());
                bDEmotionBagVerticalLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.dip2px(AppRuntime.getAppContext(), 260.0f)));
                bDEmotionBagVerticalLayout.setEmotionList(EmotionUtils.getInstance().getPanelEmotionList());
                ArrayList arrayList = new ArrayList();
                arrayList.add(bDEmotionBagVerticalLayout);
                ((ViewPager) viewGroup.findViewById(R.id.vp_emotion_type)).setAdapter(new NoHorizontalScrollerVPAdapter(arrayList));
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

    public static BDEmotionPanelManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
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

    private void handleEmotionTypeLayoutNightMode(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, viewGroup) == null) {
            View findViewById = viewGroup.findViewById(R.id.emotion_type_placeholer);
            View findViewById2 = viewGroup.findViewById(R.id.emotion_type_layout);
            if (this.isNightMode) {
                findViewById.setBackgroundColor(-14540254);
                findViewById2.setBackgroundColor(-13421773);
            } else {
                findViewById.setBackgroundColor(-1);
                findViewById2.setBackgroundColor(COLOR_EMOTION_TYPE_LAYOUT);
            }
            findViewById2.setVisibility(8);
            findViewById.setVisibility(8);
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GlobalOnItemClickListenerManager.getInstance().dismiss();
            sInstance = null;
        }
    }

    public boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isNightMode : invokeV.booleanValue;
    }

    public void loadInnerEmotionPanel(Activity activity, ViewGroup viewGroup, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, viewGroup, view, Boolean.valueOf(z)}) == null) {
            if (DEBUG) {
                this.mLastStackInfo = Log.getStackTraceString(new Exception());
            }
            sMainHandler.post(new Runnable(this, activity, viewGroup, view, z) { // from class: com.baidu.spswitch.utils.BDEmotionPanelManager.1
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
                        Object[] objArr = {this, activity, viewGroup, view, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$activity = activity;
                    this.val$panelLayout = viewGroup;
                    this.val$focusView = view;
                    this.val$isNightMode = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doLoadInnerEmotionPanel(this.val$activity, this.val$panelLayout, this.val$focusView, this.val$isNightMode);
                    }
                }
            });
        }
    }

    public void setOnEmotionClickListener(OnEmotionClickListener onEmotionClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onEmotionClickListener) == null) {
            GlobalOnItemClickListenerManager.getInstance().setOnEmotionClickListener(onEmotionClickListener);
        }
    }

    public void setOnVerticalEmotionListener(OnVerticalEmotionListener onVerticalEmotionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onVerticalEmotionListener) == null) {
            GlobalOnItemClickListenerManager.getInstance().setOnVerticalEmotionListener(onVerticalEmotionListener);
        }
    }
}
