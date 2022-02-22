package com.baidu.nadcore.widget.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.d.e;
import c.a.d0.d.h;
import c.a.d0.h0.r;
import c.a.d0.j.f.d;
import c.a.d0.s.b;
import c.a.d0.s.s;
import c.a.d0.v.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedVideoBaseView;
import com.baidu.nadcore.widget.uitemplate.DislikeBottomDialog;
import com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView;
import com.baidu.nadcore.widget.uitemplate.NadRewardOperateView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class NadRewardBaseView extends AdFeedVideoBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivityOrientationState;
    public WeakReference<Activity> mActivityRef;
    public int mActivitySystemUIVisible;
    public boolean mDislikeClicked;
    public NadRewardOperateView mOperateBar;
    public c.a.d0.l0.z.a mRewardMediaListener;
    public NadRewardCountDownView mSkipButton;

    /* loaded from: classes11.dex */
    public class a implements DislikeBottomDialog.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardBaseView a;

        public a(NadRewardBaseView nadRewardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardBaseView;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.DislikeBottomDialog.d
        public void a(List<b.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), h.nad_dislike_reduce_recommend, 0).show();
                this.a.mDislikeClicked = true;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            p pVar = this.mNativePlayer;
            if (pVar != null) {
                pVar.release();
                this.mNativePlayer = null;
            }
            d dVar = this.mNativeDownloadPresenter;
            if (dVar != null) {
                dVar.m();
                this.mNativeDownloadPresenter = null;
            }
            if (this.mOperateBar != null) {
                this.mOperateBar = null;
            }
            NadRewardCountDownView nadRewardCountDownView = this.mSkipButton;
            if (nadRewardCountDownView != null) {
                nadRewardCountDownView.release();
                this.mSkipButton = null;
            }
            WeakReference<Activity> weakReference = this.mActivityRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mActivityRef.get().setRequestedOrientation(this.mActivityOrientationState);
            h();
        }
    }

    public void doInitLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            initLayout(context);
        }
    }

    public final void h() {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (weakReference = this.mActivityRef) == null || weakReference.get() == null) {
            return;
        }
        View decorView = this.mActivityRef.get().getWindow().getDecorView();
        decorView.setSystemUiVisibility(this.mActivitySystemUIVisible);
        decorView.requestLayout();
    }

    public void hideSystemUI() {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.mActivityRef) == null || weakReference.get() == null) {
            return;
        }
        r.a(this.mActivityRef.get().getWindow());
    }

    public abstract void initInflate(LayoutInflater layoutInflater, s sVar);

    public abstract void initLayout(Context context);

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onDislikeBtnClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.mDislikeClicked) {
                Toast.makeText(getContext(), h.nad_dislike_reduce_repeat, 0).show();
                if (this.mBottomDialog != null) {
                    this.mBottomDialog = null;
                    return;
                }
                return;
            }
            if (this.mBottomDialog == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.mBottomDialog = new DislikeBottomDialog(getContext(), (AdBaseModel) getTag());
            }
            this.mBottomDialog.setDislikeListener(new a(this));
            this.mBottomDialog.showInImmersive();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (i2 == 0) {
                hideSystemUI();
            }
        }
    }

    public void setRewardMediaListener(c.a.d0.l0.z.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.mRewardMediaListener = aVar;
        }
    }

    public void showRewardAd(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, activity) == null) && activity != null && (activity.getWindow().getDecorView() instanceof ViewGroup)) {
            this.mActivityRef = new WeakReference<>(activity);
            this.mActivityOrientationState = activity.getRequestedOrientation();
            updateOrientationState();
            this.mActivitySystemUIVisible = activity.getWindow().getDecorView().getSystemUiVisibility();
            hideSystemUI();
            ((ViewGroup) activity.getWindow().getDecorView()).addView(this, new FrameLayout.LayoutParams(-1, -1));
            bringToFront();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adBaseModel) == null) {
            super.update(adBaseModel);
            updateSubViewData(adBaseModel);
            updateSkipButton(adBaseModel);
            updateOperateBar(adBaseModel);
            updateSubViewUi(adBaseModel);
            requestFocus();
        }
    }

    public final void updateOperateBar(AdBaseModel adBaseModel) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, adBaseModel) == null) || (viewGroup = (ViewGroup) findViewById(e.reward_ad_operate_view)) == null) {
            return;
        }
        viewGroup.setVisibility(8);
        if (this.mOperateBar == null) {
            this.mOperateBar = new NadRewardOperateView(getContext());
        }
        this.mOperateBar.update(adBaseModel);
        this.mOperateBar.bindContainer(viewGroup);
        c.a.d0.l0.x.a aVar = this.mNadDownloadListener;
        if (aVar != null) {
            this.mOperateBar.setViewDownloadListener(aVar);
        }
        c.a.d0.l0.x.b bVar = this.mFeedListener;
        if (bVar != null) {
            this.mOperateBar.setFeedListener(bVar);
        }
    }

    public abstract void updateOrientationState();

    public void updateSkipButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adBaseModel) == null) {
            NadRewardCountDownView nadRewardCountDownView = (NadRewardCountDownView) findViewById(e.nad_reward_skip_btn);
            this.mSkipButton = nadRewardCountDownView;
            if (nadRewardCountDownView == null) {
                return;
            }
            nadRewardCountDownView.update(adBaseModel);
        }
    }

    public abstract void updateSubViewData(AdBaseModel adBaseModel);

    public abstract void updateSubViewUi(AdBaseModel adBaseModel);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i2, s sVar) {
        super(context, attributeSet, i2, sVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), sVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        initInflate(LayoutInflater.from(context), sVar);
        doInitLayout(context);
    }
}
