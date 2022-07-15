package com.baidu.live.business;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
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
public class Live4Ratio5ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView d;
    public SimpleDraweeView e;
    public LiveStatusAnimView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public SimpleDraweeView j;
    public boolean k;
    public View l;
    public View m;
    public TextView n;
    public SimpleDraweeView o;
    public Context p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5ItemView(Context context) {
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
        this.k = false;
        d(context);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (this.k && this.f.b()) {
                this.f.c();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            LiveStatusAnimView liveStatusAnimView = this.f;
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
            LiveStatusAnimView liveStatusAnimView = this.f;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            setNeedRatio(true);
            setAspectRatio(1.25f);
            this.p = context;
            View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0507, this);
            this.d = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912ff);
            this.f = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f091302);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091305);
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912fb);
            this.e = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912fc);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091303);
            this.j = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091304);
            this.l = inflate.findViewById(R.id.obfuscated_res_0x7f0912f2);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091337);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091338);
            this.o = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091339);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SimpleDraweeView simpleDraweeView = this.d;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(eb0.e().j(this.c), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.e;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(eb0.e().j(this.c), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.g;
            if (textView != null) {
                textView.setTextColor(eb0.e().a(getContext(), this.c, "color_white3"));
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setTextColor(eb0.e().a(getContext(), this.c, "color_white3"));
            }
            TextView textView3 = this.h;
            if (textView3 != null) {
                textView3.setTextColor(eb0.e().a(getContext(), this.c, "color_white3"));
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, liveRoomEntity, i) == null) {
            this.f.setIsImmersion(this.c);
            if (liveRoomEntity != null) {
                this.d.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && leftLableInfo.canShowLabel() && (liveStatusAnimView = this.f) != null) {
                    int i2 = liveRoomEntity.liveStatus;
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    liveStatusAnimView.setData(i2, leftLableInfo2.text, leftLableInfo2.startColor, leftLableInfo2.endColor);
                    this.k = true;
                    this.f.setVisibility(0);
                } else {
                    this.k = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.f;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
                this.g.setText(liveRoomEntity.title);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.i.setText(liveHostInfo.name);
                    this.e.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
                if (liveRoomEntity.liveStatus == 0) {
                    this.h.setVisibility(8);
                } else {
                    this.h.setText(x80.a(this.p, liveRoomEntity.audienceCount));
                    this.h.setVisibility(0);
                }
                this.l.getLayoutParams().height = t80.a(getContext(), 61.0f);
                this.l.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cab));
                if (liveRoomEntity.showTpl == 1) {
                    this.e.setVisibility(0);
                    this.g.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.g.setVisibility(8);
                    this.i.setTextSize(1, 14.0f);
                    this.i.setTypeface(Typeface.defaultFromStyle(1));
                    this.l.getLayoutParams().height = t80.a(getContext(), 35.0f);
                    this.l.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ca8));
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
                    this.e.getHierarchy().setUseGlobalColorFilter(false);
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
    public Live4Ratio5ItemView(Context context, AttributeSet attributeSet) {
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
        this.k = false;
        d(context);
    }
}
