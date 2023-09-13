package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.CardPeiWanView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cra;
import com.baidu.tieba.ey5;
import com.baidu.tieba.hq6;
import com.baidu.tieba.tbadkCore.voice.VoicePlayBtn;
import com.baidu.tieba.vx;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendTag;
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0014H\u0002J\u001e\u0010'\u001a\u00020%2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010)\u001a\u00020\bH\u0016J\u0018\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002J0\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020%\u0018\u0001012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020%\u0018\u000101R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\b\u0012\u0004\u0012\u00020\u000f`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0011j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/tbadk/core/view/CardPeiWanView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/card/IChangeSkinAble;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coverView", "Landroid/view/View;", "labelTopLeft", "Landroid/widget/LinearLayout;", "labelTopLeftText", "Landroid/widget/TextView;", "labels", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "labelsData", "Ltbclient/ThreadRecommendTag;", "labelsLayout", "resultBackgroundColor", "getResultBackgroundColor", "()I", "setResultBackgroundColor", "(I)V", "resultTextColor", "getResultTextColor", "setResultTextColor", "statusView", "Landroid/widget/FrameLayout;", "thumbnailImg", "Lcom/baidu/tbadk/widget/TbImageView;", "voicePlayBtn", "Lcom/baidu/tieba/tbadkCore/voice/VoicePlayBtn;", "addTagTextView", "", "tag", "onChangeSkinType", "Lcom/baidu/tbadk/TbPageContext;", WriteMulitImageActivityConfig.SKIN_TYPE, "setCoverViewLp", "width", "height", "setData", "cardPeiWanData", "Lcom/baidu/tieba/card/data/CardPeiWanData;", "cardClickCallback", "Lkotlin/Function0;", "voiceClickCallBack", "Companion", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardPeiWanView extends RelativeLayout implements vx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;
    public final FrameLayout b;
    public final TextView c;
    public LinearLayout d;
    public ArrayList<TextView> e;
    public ArrayList<ThreadRecommendTag> f;
    public final TbImageView g;
    public final View h;
    public final VoicePlayBtn i;
    public int j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1022863225, "Lcom/baidu/tbadk/core/view/CardPeiWanView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1022863225, "Lcom/baidu/tbadk/core/view/CardPeiWanView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardPeiWanView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardPeiWanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes4.dex */
    public static final class a implements VoicePlayBtn.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> function0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function0;
        }

        @Override // com.baidu.tieba.tbadkCore.voice.VoicePlayBtn.a
        public void onClick() {
            Function0<Unit> function0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (function0 = this.a) != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardPeiWanView(Context context, AttributeSet attributeSet, int i) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new LinearLayout(context);
        this.b = new FrameLayout(context);
        this.c = new TextView(context);
        this.d = new LinearLayout(context);
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.g = new TbImageView(context);
        this.h = new View(context);
        this.i = new VoicePlayBtn(context);
        this.j = SkinManager.getColor(R.color.CAM_X0101);
        this.k = SkinManager.getColor(R.color.CAM_X0611);
        this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        this.h.setBackgroundResource(R.drawable.bg_img_mask);
        this.h.setId(R.id.card_peiwan_cover);
        EMManager.from(this.h).setCorner(R.string.J_X05);
        addView(this.h, new RelativeLayout.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = BdUtilHelper.getDimens(context, R.dimen.tbds650);
            layoutParams2.height = BdUtilHelper.getDimens(context, R.dimen.tbds650);
            this.g.setLayoutParams(layoutParams2);
            this.g.setPlaceHolder(3);
            this.g.setDefaultResource(0);
            this.g.setRadiusById(R.string.J_X05);
            this.g.setConrers(15);
            this.g.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.g.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.g.setBorderSurroundContent(true);
            this.g.setDrawCorner(true);
            this.g.setDrawBorder(true);
            b(layoutParams2.width, layoutParams2.height);
            this.a.setOrientation(0);
            this.a.setGravity(16);
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds26);
            int dimens2 = BdUtilHelper.getDimens(context, R.dimen.tbds13);
            int dimens3 = BdUtilHelper.getDimens(context, R.dimen.tbds6);
            this.a.addView(this.b, new LinearLayout.LayoutParams(dimens, dimens));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = dimens2;
            layoutParams3.topMargin = dimens3;
            layoutParams3.bottomMargin = dimens3;
            this.a.addView(this.c, layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.leftMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X006);
            layoutParams4.topMargin = BdUtilHelper.getDimens(context, R.dimen.M_H_X004);
            this.a.setPadding(dimens2, 0, BdUtilHelper.getDimens(context, R.dimen.M_W_X004), 0);
            addView(this.a, layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(8, R.id.card_peiwan_cover);
            layoutParams5.leftMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X006);
            layoutParams5.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.tbds97);
            addView(this.i, layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.addRule(8, R.id.card_peiwan_cover);
            layoutParams6.leftMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X004);
            layoutParams6.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.tbds29);
            addView(this.d, layoutParams6);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public /* synthetic */ CardPeiWanView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void c(hq6 it, Function0 function0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, it, function0, view2) == null) {
            Intrinsics.checkNotNullParameter(it, "$it");
            UrlManager.getInstance().dealOneLink(it.g());
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void a(ThreadRecommendTag threadRecommendTag) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, threadRecommendTag) != null) || TextUtils.isEmpty(threadRecommendTag.text)) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(ey5.f(threadRecommendTag.text, 10));
        textView.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), BdUtilHelper.getDimens(getContext(), R.dimen.tbds4), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), BdUtilHelper.getDimens(getContext(), R.dimen.tbds4));
        textView.setMaxLines(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
        this.d.addView(textView, layoutParams);
        this.e.add(textView);
        this.f.add(threadRecommendTag);
    }

    public final void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.h.setLayoutParams(layoutParams);
        }
    }

    public final int getResultBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final int getResultTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            EMManager.from(this.a).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0605);
            EMManager.from(this.b).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0309);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            EMManager.from(this.c).setTextSize(R.dimen.T_X09);
            EMManager.from(this.g).setCorner(R.string.J_X05).setBorderWidth(R.dimen.L_X01);
            if (this.e.size() > 0 && this.e.size() == this.f.size()) {
                Iterator<TextView> it = this.e.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    int i3 = i2 + 1;
                    TextView next = it.next();
                    ThreadRecommendTag threadRecommendTag = this.f.get(i2);
                    Intrinsics.checkNotNullExpressionValue(threadRecommendTag, "labelsData[i]");
                    ThreadRecommendTag threadRecommendTag2 = threadRecommendTag;
                    ThemeColorInfo themeColorInfo = threadRecommendTag2.text_color;
                    Intrinsics.checkNotNullExpressionValue(themeColorInfo, "tagData.text_color");
                    int f = zfa.f(cra.c(themeColorInfo));
                    if (!zfa.e(f)) {
                        this.j = f;
                    }
                    ThemeColorInfo themeColorInfo2 = threadRecommendTag2.background_color;
                    Intrinsics.checkNotNullExpressionValue(themeColorInfo2, "tagData.background_color");
                    int f2 = zfa.f(cra.c(themeColorInfo2));
                    if (!zfa.e(f2)) {
                        this.k = f2;
                    }
                    next.setTextColor(this.j);
                    EMManager.from(next).setCorner(R.string.J_X04).setTextSize(R.dimen.T_X10).setBackGroundRealColor(this.k);
                    i2 = i3;
                }
            }
        }
    }

    public final void setData(final hq6 hq6Var, final Function0<Unit> function0, Function0<Unit> function02) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, hq6Var, function0, function02) == null) && hq6Var != null) {
            if (TextUtils.isEmpty(hq6Var.f())) {
                this.a.setVisibility(8);
            } else {
                this.a.setVisibility(0);
            }
            this.c.setText(ey5.f(hq6Var.f(), 6));
            this.g.startLoad(hq6Var.c());
            if (hq6Var.i() == null) {
                this.i.setVisibility(8);
            } else {
                this.i.setData(hq6Var.i());
                this.i.setVisibility(0);
            }
            this.i.setMClickCallBack(new a(function02));
            List<ThreadRecommendTag> h = hq6Var.h();
            this.d.removeAllViews();
            this.e.clear();
            this.f.clear();
            if (h != null) {
                for (ThreadRecommendTag threadRecommendTag : h) {
                    if (h.indexOf(threadRecommendTag) > 3) {
                        break;
                    }
                    a(threadRecommendTag);
                }
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s95
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        CardPeiWanView.c(hq6.this, function0, view2);
                    }
                }
            });
            onChangeSkinType(TbadkCoreApplication.getInst().getCurrentPageContext(getContext()), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void setResultBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.k = i;
        }
    }

    public final void setResultTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.j = i;
        }
    }
}
