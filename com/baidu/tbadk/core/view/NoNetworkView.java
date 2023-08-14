package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.NoNetworkMoreActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.zda;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GONE = 0;
    public static final int SHOW_NO_NET = 1;
    public static final int SHOW_OFFLINE = 2;
    public static boolean mHasNetwork;
    public static ArrayList<NoNetworkView> mViews;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentState;
    public boolean isSupportOffline;
    public TextView mCheckDetail;
    public Context mContext;
    public TextView mGuide;
    public final ArrayList<b> networkChangeListeners;

    /* loaded from: classes4.dex */
    public interface b {
        void k(boolean z);
    }

    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.no_network_view : invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NoNetworkView a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public a(NoNetworkView noNetworkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {noNetworkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = noNetworkView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.setVisibility(8);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(470600422, "Lcom/baidu/tbadk/core/view/NoNetworkView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(470600422, "Lcom/baidu/tbadk/core/view/NoNetworkView;");
                return;
            }
        }
        mViews = new ArrayList<>();
    }

    public static void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                setIsHasNetwork(true);
            } else {
                setIsHasNetwork(false);
            }
        }
    }

    public void hideCheckDetail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mCheckDetail.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            mViews.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            mViews.remove(this);
            this.networkChangeListeners.clear();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoNetworkView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentState = 0;
        this.networkChangeListeners = new ArrayList<>();
        init(context, null);
    }

    public static void setIsHasNetwork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            mHasNetwork = z;
            if (z) {
                Iterator<NoNetworkView> it = mViews.iterator();
                while (it.hasNext()) {
                    it.next().update(false);
                }
                return;
            }
            Iterator<NoNetworkView> it2 = mViews.iterator();
            while (it2.hasNext()) {
                it2.next().update(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.currentState = 0;
        this.networkChangeListeners = new ArrayList<>();
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.currentState = 0;
        this.networkChangeListeners = new ArrayList<>();
        init(context, attributeSet);
    }

    public void addNetworkChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) || bVar == null || this.networkChangeListeners.contains(bVar)) {
            return;
        }
        this.networkChangeListeners.add(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 == this && getVisibility() == 0) {
            Intent intent = new Intent(this.mContext, NoNetworkMoreActivity.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.mContext.startActivity(intent);
        }
    }

    public void removeNetworkChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) && bVar != null && this.networkChangeListeners.contains(bVar)) {
            this.networkChangeListeners.remove(bVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            clearAnimation();
            super.setVisibility(i);
        }
    }

    public void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            this.mContext = context;
            LayoutInflater.from(context).inflate(getLayout(), this);
            this.mGuide = (TextView) findViewById(R.id.no_network_guide);
            this.mCheckDetail = (TextView) findViewById(R.id.check_detail_view);
            setOnClickListener(this);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zda.noNetworkView);
                this.isSupportOffline = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
            }
            try {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    update(false);
                    setIsHasNetwork(true);
                    return;
                }
                update(true);
                setIsHasNetwork(false);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void onChangeSkinType(BdPageContext<?> bdPageContext, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, bdPageContext, i) == null) {
            if (bdPageContext instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) bdPageContext;
                BDLayoutMode layoutMode = tbPageContext.getLayoutMode();
                if (i == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.setNightMode(z);
                tbPageContext.getLayoutMode().onModeChanged(this);
            }
            SkinManager.setBackgroundResource(this, R.drawable.nonetworkview_bg_selector, i);
        }
    }

    public void update(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                if (1 == this.currentState) {
                    return;
                }
                this.currentState = 1;
                this.mGuide.setText(R.string.no_network_guide);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.networkChangeListeners.size(); i++) {
                    this.networkChangeListeners.get(i).k(false);
                }
            } else if (this.isSupportOffline && !BdSocketLinkService.isAvailable()) {
                if (2 == this.currentState) {
                    return;
                }
                this.currentState = 2;
                this.mGuide.setText(R.string.offline_guide);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.networkChangeListeners.size(); i2++) {
                    this.networkChangeListeners.get(i2).k(false);
                }
            } else if (this.currentState != 0) {
                this.currentState = 0;
                if (getVisibility() != 8) {
                    AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.8f);
                    alphaAnimation3.setFillAfter(true);
                    alphaAnimation3.setDuration(500L);
                    alphaAnimation3.setAnimationListener(new a(this));
                    startAnimation(alphaAnimation3);
                    for (int i3 = 0; i3 < this.networkChangeListeners.size(); i3++) {
                        this.networkChangeListeners.get(i3).k(true);
                    }
                }
            }
        }
    }
}
