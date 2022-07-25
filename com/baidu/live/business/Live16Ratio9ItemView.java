package com.baidu.live.business;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.model.data.ThirdLabelInfo;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.mobstat.Config;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.eb0;
import com.repackage.t80;
import com.repackage.x80;
/* loaded from: classes2.dex */
public class Live16Ratio9ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView d;
    public LiveStatusAnimView e;
    public TextView f;
    public TextView g;
    public SimpleDraweeView h;
    public TextView i;
    public SimpleDraweeView j;
    public FrameLayout k;
    public boolean l;
    public View m;
    public TextView n;
    public SimpleDraweeView o;
    public float[] p;
    public Context q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live16Ratio9ItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        d(context);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (this.l && this.e.b()) {
                this.e.c();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            LiveStatusAnimView liveStatusAnimView = this.e;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            LiveStatusAnimView liveStatusAnimView = this.e;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.q = context;
            setNeedRatio(false);
            int c = (int) (((t80.c(context) - (t80.a(context, 12.0f) * 2)) - t80.a(context, 7.0f)) / 2.0d);
            View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0510, this);
            this.d = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912db);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0912dc);
            this.k = frameLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = c;
            layoutParams.height = (int) ((c * 9) / 16.0d);
            this.k.setLayoutParams(layoutParams);
            this.e = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f0912dd);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912e1);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912df);
            this.h = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912d8);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912da);
            this.j = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912e0);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091313);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091314);
            this.o = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091315);
            float a = t80.a(getContext(), 10.0f);
            this.p = new float[]{a, a, a, a, a, a, a, a};
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(eb0.e().a(getContext(), this.c, "color_white2"));
            gradientDrawable.setCornerRadii(this.p);
            setBackgroundDrawable(gradientDrawable);
            SimpleDraweeView simpleDraweeView = this.d;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(eb0.e().j(this.c), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.h;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(eb0.e().j(this.c), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.g;
            if (textView != null) {
                textView.setTextColor(eb0.e().a(getContext(), this.c, "color_1F1F1F"));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setTextColor(eb0.e().a(getContext(), this.c, "color_858585"));
            }
            TextView textView3 = this.i;
            if (textView3 != null) {
                textView3.setTextColor(eb0.e().a(getContext(), this.c, "color_858585"));
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, liveRoomEntity, i) == null) {
            this.e.setIsImmersion(this.c);
            if (liveRoomEntity != null) {
                this.d.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && leftLableInfo.canShowLabel() && (liveStatusAnimView = this.e) != null) {
                    int i2 = liveRoomEntity.liveStatus;
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    liveStatusAnimView.setData(i2, leftLableInfo2.text, leftLableInfo2.startColor, leftLableInfo2.endColor);
                    this.l = true;
                    this.e.setVisibility(0);
                } else {
                    this.l = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.e;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
                this.g.setText(liveRoomEntity.title);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.f.setText(liveHostInfo.name);
                    this.h.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
                if (liveRoomEntity.liveStatus == 0) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setText(x80.a(this.q, liveRoomEntity.audienceCount));
                    this.i.setVisibility(0);
                }
                RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
                if (rightLableInfo != null && rightLableInfo.canShowLabel()) {
                    this.j.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                    this.j.setVisibility(0);
                } else {
                    this.j.setVisibility(8);
                }
                if (this.c) {
                    this.d.getHierarchy().setUseGlobalColorFilter(false);
                    this.h.getHierarchy().setUseGlobalColorFilter(false);
                    this.j.getHierarchy().setUseGlobalColorFilter(false);
                }
                ThirdLabelInfo thirdLabelInfo = liveRoomEntity.thirdLabel;
                if (thirdLabelInfo != null && thirdLabelInfo.canShowLabel()) {
                    this.m.setVisibility(0);
                    this.n.setText(liveRoomEntity.thirdLabel.text);
                    if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.iconUrl)) {
                        this.o.setImageURI(liveRoomEntity.thirdLabel.iconUrl);
                        this.o.setVisibility(0);
                    } else {
                        this.o.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.startColor) && !TextUtils.isEmpty(liveRoomEntity.thirdLabel.endColor)) {
                        try {
                            ((GradientDrawable) this.m.getBackground()).setColors(new int[]{Color.parseColor(liveRoomEntity.thirdLabel.startColor), Color.parseColor(liveRoomEntity.thirdLabel.endColor)});
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    this.m.setVisibility(8);
                }
                e(Config.TRACE_VISIT_RECENT_DAY);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live16Ratio9ItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = false;
        d(context);
    }
}
