package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.f0.o.a;
import d.a.r0.r.f0.q.b;
import java.util.List;
import tbclient.Item;
/* loaded from: classes4.dex */
public class ItemCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f12421e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12422f;

    /* renamed from: g  reason: collision with root package name */
    public RankStarView f12423g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12424h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12425i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public TBSpecificationBtn n;
    public Path o;
    public RectF p;
    public int q;
    public int r;
    public int s;
    public String t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1054421578, "Lcom/baidu/tbadk/core/view/ItemCardView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1054421578, "Lcom/baidu/tbadk/core/view/ItemCardView;");
                return;
            }
        }
        u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        w = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        x = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        y = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        z = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        A = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        B = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemCardView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setBtnRight(Item item) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, this, item) == null) || item == null) {
            return;
        }
        a aVar = new a(item, this.s);
        ItemCardHelper.j(this.n, aVar);
        Item a2 = aVar.a();
        this.n.setText(a2.button_name);
        this.n.k();
        int c2 = ItemCardHelper.c(a2.button_name);
        if (-1 != c2) {
            ItemCardHelper.l(this.s, a2.item_id.longValue(), c2);
        }
    }

    private void setTag(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                this.k.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    spannableStringBuilder.append((CharSequence) list.get(i2));
                    if (i2 != list.size() - 1) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                        spannableStringBuilder2.setSpan(new b(B), 0, spannableStringBuilder2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    }
                }
                this.k.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return;
            }
            this.k.setVisibility(8);
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
            this.f12421e = (TbImageView) findViewById(R.id.item_image);
            this.f12422f = (TextView) findViewById(R.id.item_title);
            this.f12423g = (RankStarView) findViewById(R.id.item_star);
            this.f12424h = (TextView) findViewById(R.id.item_score);
            this.f12425i = (TextView) findViewById(R.id.tieba_score_tag);
            this.j = (TextView) findViewById(R.id.item_des);
            this.k = (TextView) findViewById(R.id.item_tag);
            this.l = (ImageView) findViewById(R.id.bt_del);
            this.m = (ImageView) findViewById(R.id.img_right);
            this.n = (TBSpecificationBtn) findViewById(R.id.order_or_download);
            this.f12421e.setDrawCorner(true);
            this.f12421e.setConrers(15);
            this.f12421e.setRadiusById(R.string.J_X04);
            this.f12421e.setPlaceHolder(1);
            this.f12421e.setDrawBorder(true);
            this.f12423g.setStarSpacing(l.g(context, R.dimen.tbds10));
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, this.q);
            SkinManager.setViewTextColor(this.f12422f, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f12424h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.f12425i, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.m, R.drawable.icon_pb_right_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f12421e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.f12421e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f12423g.f();
            this.f12423g.invalidate();
            this.f12421e.setPlaceHolder(1);
            this.n.k();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.r == 1) {
            this.f12422f.setTextSize(0, l.g(getContext(), R.dimen.T_X07));
            this.j.setTextSize(0, l.g(getContext(), R.dimen.tbds31));
            this.k.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
            ((LinearLayout.LayoutParams) this.f12423g.getLayoutParams()).height = l.g(getContext(), R.dimen.tbds32);
            this.f12423g.setStarSpacing(l.g(getContext(), R.dimen.tbds3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = l.g(getContext(), R.dimen.tbds5);
            this.k.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.o.reset();
            this.p.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            Path path = this.o;
            RectF rectF = this.p;
            int i2 = A;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            canvas.clipPath(this.o);
            super.draw(canvas);
        }
    }

    public TbImageView getItemImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12421e : (TbImageView) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.s : invokeV.intValue;
    }

    public RankStarView getStarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12423g : (RankStarView) invokeV.objValue;
    }

    public TextView getTagView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f12422f : (TextView) invokeV.objValue;
    }

    public void setBackGroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.q = i2;
            b();
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, tbRichTextEvaluateItemInfo, i2) == null) {
            if (!TextUtils.isEmpty(this.t + tbRichTextEvaluateItemInfo.getTitle())) {
                SpannableString spannableString = new SpannableString(tbRichTextEvaluateItemInfo.getTitle());
                UtilHelper.setSpan(spannableString, tbRichTextEvaluateItemInfo.getTitle(), this.t, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
                this.f12422f.setText(spannableString);
            } else {
                this.f12422f.setText(tbRichTextEvaluateItemInfo.getTitle());
            }
            this.f12421e.M(tbRichTextEvaluateItemInfo.getIconUrl(), i2, false);
            if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
                this.f12423g.setStarCount(tbRichTextEvaluateItemInfo.getStar());
            } else {
                this.f12423g.setStarCount(0.0f);
            }
            if (tbRichTextEvaluateItemInfo.getScore() > 0.0d && tbRichTextEvaluateItemInfo.getScore() <= 10.0d) {
                this.f12424h.setText(tbRichTextEvaluateItemInfo.getScore() + "");
                this.f12425i.setText(R.string.tieba_score);
            } else {
                this.f12424h.setText(R.string.no_evaluate_now);
                this.f12425i.setText(R.string.no_tieba_score);
            }
            setTag(tbRichTextEvaluateItemInfo.getTags());
            setBtnRight(tbRichTextEvaluateItemInfo.getItem());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12421e.getLayoutParams();
            if (this.r == 1) {
                if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                    layoutParams.width = u;
                    layoutParams.height = v;
                } else if (tbRichTextEvaluateItemInfo.getIconSize() < 1.0d) {
                    layoutParams.width = w;
                    layoutParams.height = x;
                } else {
                    layoutParams.width = y;
                    layoutParams.height = z;
                }
                layoutParams.width -= l.g(getContext(), R.dimen.tbds5);
                layoutParams.height -= l.g(getContext(), R.dimen.tbds5);
            } else if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                layoutParams.width = u;
                layoutParams.height = v;
            } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
                layoutParams.width = w;
                layoutParams.height = x;
            } else {
                layoutParams.width = y;
                layoutParams.height = z;
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            layoutParams2.height = layoutParams.height + l.g(getContext(), R.dimen.tbds42);
            this.f12421e.setLayoutParams(layoutParams);
            setLayoutParams(layoutParams2);
        }
    }

    public void setHighLightText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.t = str;
        }
    }

    public void setIsShowRightBtn(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            if (z2) {
                this.n.setVisibility(0);
                this.m.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            this.m.setVisibility(0);
        }
    }

    public void setOnClickListenerOfRightBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.n.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setSizeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.r = i2;
            d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = R.color.CAM_X0206;
        this.r = 0;
        this.o = new Path();
        this.p = new RectF();
        a(context);
    }

    public void setData(Item item, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, item, i2) == null) {
            if (!TextUtils.isEmpty(item.item_name + this.t)) {
                UtilHelper.setSpan(new SpannableString(item.item_name), item.item_name, this.t, new ForegroundColorSpan(Color.parseColor("#0AC3BC")));
            }
            this.f12422f.setText(item.item_name);
            this.f12421e.M(item.icon_url, i2, false);
            if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
                this.f12423g.setStarCount(item.star.intValue());
            } else {
                this.f12423g.setStarCount(0.0f);
            }
            if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
                this.f12424h.setText(item.score + "");
                this.f12425i.setText(R.string.tieba_score);
            } else {
                this.f12424h.setText(R.string.no_evaluate_now);
                this.f12424h.setText(R.string.no_tieba_score);
            }
            setTag(item.tags);
            setBtnRight(item);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12421e.getLayoutParams();
            if (this.r == 1) {
                if (item.icon_size.doubleValue() == 1.0d) {
                    layoutParams.width = u;
                    layoutParams.height = v;
                } else if (item.icon_size.doubleValue() < 1.0d) {
                    layoutParams.width = w;
                    layoutParams.height = x;
                } else {
                    layoutParams.width = y;
                    layoutParams.height = z;
                }
                layoutParams.width -= l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                layoutParams.height -= l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            } else if (item.icon_size.doubleValue() == 1.0d) {
                layoutParams.width = u;
                layoutParams.height = v;
            } else if (item.icon_size.doubleValue() == 0.67d) {
                layoutParams.width = w;
                layoutParams.height = x;
            } else {
                layoutParams.width = y;
                layoutParams.height = z;
            }
            if (item.icon_size.doubleValue() == 1.0d) {
                int i3 = this.r;
                if (i3 == 0) {
                    layoutParams.width = u;
                    layoutParams.height = v;
                } else if (i3 == 1) {
                    layoutParams.width = u - l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                    layoutParams.height = v - l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                }
            } else if (item.icon_size.doubleValue() == 0.67d) {
                layoutParams.width = w;
                layoutParams.height = x;
            } else {
                layoutParams.width = y;
                layoutParams.height = z;
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            layoutParams2.height = layoutParams.height + l.g(getContext(), R.dimen.tbds42);
            this.f12421e.setLayoutParams(layoutParams);
            setLayoutParams(layoutParams2);
        }
    }
}
