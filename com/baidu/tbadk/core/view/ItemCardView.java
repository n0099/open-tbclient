package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton;
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
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes6.dex */
public class ItemCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVALUATE_STYLE = 1;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int I;
    public static final int J;
    public static final int K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int NORMA_STYLE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public int C;
    public String D;
    public String E;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f47538e;

    /* renamed from: f  reason: collision with root package name */
    public ItemEllipsisView f47539f;

    /* renamed from: g  reason: collision with root package name */
    public ItemEllipsisView f47540g;

    /* renamed from: h  reason: collision with root package name */
    public ItemEllipsisView f47541h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f47542i;

    /* renamed from: j  reason: collision with root package name */
    public ItemCardDownloadButton f47543j;
    public TBSpecificationBtn k;
    public String l;
    public long m;
    public String n;
    public double o;
    public List<String> p;
    public String q;
    public String r;
    public String s;
    public String t;
    public float u;
    public int v;
    public Path w;
    public RectF x;
    public int y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47546a;

        public a(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47546a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.f47546a.f47543j.getObjTypeByDownloadMode();
                int a2 = c.a.p0.s.f0.p.c.a(this.f47546a.f47543j.getCurrentItem().button_link_type.intValue(), this.f47546a.f47543j.getCurrentItem().apk_detail != null ? this.f47546a.f47543j.getCurrentItem().apk_detail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a2 == 4) {
                    return;
                }
                ItemCardHelper.n(this.f47546a.C, this.f47546a.m, objTypeByDownloadMode, this.f47546a.n, a2, "");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47547a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ItemCardView itemCardView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47547a = itemCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.f47547a.f47543j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    ItemCardHelper.n(this.f47547a.C, this.f47547a.m, objTypeByDownloadMode, this.f47547a.n, c.a.p0.s.f0.p.c.a(this.f47547a.f47543j.getCurrentItem().button_link_type.intValue(), this.f47547a.f47543j.getCurrentItem().apk_detail != null ? this.f47547a.f47543j.getCurrentItem().apk_detail.pkg_source.intValue() : 0), str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47548a;

        public c(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47548a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean b(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, layout)) == null) {
                if (layout != null) {
                    return i2 > 1 && ((float) this.f47548a.l.length()) > (((float) layout.getLineEnd(0)) - this.f47548a.u) - 1.0f;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder c(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layout)) == null) {
                int lineEnd = layout.getLineEnd(0);
                TextPaint paint = this.f47548a.f47539f.getPaint();
                int measuredWidth = (int) (this.f47548a.f47539f.getMeasuredWidth() - this.f47548a.u);
                if (k.isEmpty(this.f47548a.l) || paint == null || measuredWidth <= 0) {
                    ItemCardView itemCardView = this.f47548a;
                    return itemCardView.u(itemCardView.l);
                }
                while (lineEnd > 0) {
                    if (this.f47548a.l.length() >= lineEnd) {
                        if (measuredWidth > paint.measureText(this.f47548a.l.substring(0, lineEnd - 1) + "...")) {
                            break;
                        }
                    }
                    lineEnd--;
                }
                if (lineEnd > 0) {
                    return this.f47548a.u(this.f47548a.l.substring(0, lineEnd - 1) + "...");
                }
                ItemCardView itemCardView2 = this.f47548a;
                return itemCardView2.u(itemCardView2.l);
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47549a;

        public d(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47549a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean b(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, layout)) == null) ? i2 > 1 : invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder c(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layout)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int measuredWidth = this.f47549a.f47540g.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = Integer.MAX_VALUE;
                }
                TextPaint paint = this.f47549a.f47540g.getPaint();
                if (paint == null) {
                    return spannableStringBuilder;
                }
                if (!k.isEmpty(this.f47549a.q)) {
                    measuredWidth -= (int) (ItemCardView.M + paint.measureText(((Object) this.f47549a.getContext().getText(R.string.item_version)) + this.f47549a.q));
                }
                if (ListUtils.getCount(this.f47549a.p) > 0) {
                    for (int i2 = 0; i2 < this.f47549a.p.size(); i2++) {
                        if (!k.isEmpty((String) this.f47549a.p.get(i2))) {
                            float measureText = measuredWidth - paint.measureText(((String) this.f47549a.p.get(i2)) + " ");
                            if (measureText <= 0.0f) {
                                break;
                            }
                            spannableStringBuilder.append((CharSequence) this.f47549a.p.get(i2));
                            spannableStringBuilder.append((CharSequence) " ");
                            measuredWidth = (int) measureText;
                        }
                    }
                }
                if (!k.isEmpty(this.f47549a.q)) {
                    if (spannableStringBuilder.length() > 1) {
                        spannableStringBuilder.setSpan(new c.a.p0.s.f0.r.b(ItemCardView.M), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    }
                    spannableStringBuilder.append(this.f47549a.getContext().getText(R.string.item_version));
                    spannableStringBuilder.append((CharSequence) this.f47549a.q);
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47550a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47551b;

        /* loaded from: classes6.dex */
        public class a extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f47552e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47552e = eVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f47552e.f47551b.s) && (j.a(this.f47552e.f47551b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f47552e.f47551b.getContext()), new String[]{this.f47552e.f47551b.s});
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0109));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f47553e;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47553e = eVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f47553e.f47551b.t) && (j.a(this.f47553e.f47551b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f47553e.f47551b.getContext()), new String[]{this.f47553e.f47551b.t});
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0109));
                }
            }
        }

        public e(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47551b = itemCardView;
            this.f47550a = 1;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47550a : invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean b(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, layout)) == null) {
                if (layout != null) {
                    if (i2 == 2 && this.f47551b.r != null && this.f47551b.r.endsWith(this.f47551b.E)) {
                        return true;
                    }
                    if (i2 > 0) {
                        int i3 = i2 - 1;
                        return layout.getLineEnd(i3) - layout.getLineStart(i3) < this.f47551b.v;
                    }
                    return false;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder c(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layout)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!k.isEmpty(this.f47551b.s) || !k.isEmpty(this.f47551b.t)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " |");
                    int i2 = length + 1;
                    spannableStringBuilder.setSpan(new c.a.p0.s.f0.r.b(ItemCardView.N), length, i2, 33);
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X10), new ColorStateList(new int[][]{new int[0]}, new int[]{c.a.q0.i3.c.a(SkinManager.getColor(R.color.CAM_X0108), c.a.p0.s.u.a.a(R.string.A_X10))}), null), i2, length + 2, 33);
                    if (!k.isEmpty(this.f47551b.s)) {
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f47551b.getContext().getString(R.string.item_download_privacy));
                        int i3 = length2 + 1;
                        spannableStringBuilder.setSpan(new c.a.p0.s.f0.r.b(ItemCardView.N), length2, i3, 33);
                        spannableStringBuilder.setSpan(new a(this), i3, length2 + 3, 33);
                    }
                    if (!k.isEmpty(this.f47551b.t)) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f47551b.getContext().getString(R.string.item_download_authority));
                        int i4 = length3 + 1;
                        spannableStringBuilder.setSpan(new c.a.p0.s.f0.r.b(ItemCardView.N), length3, i4, 33);
                        spannableStringBuilder.setSpan(new b(this), i4, length3 + 3, 33);
                    }
                }
                if (layout == null) {
                    spannableStringBuilder.insert(0, (CharSequence) this.f47551b.r);
                    return spannableStringBuilder;
                }
                TextPaint paint = this.f47551b.f47541h.getPaint();
                if (this.f47551b.r != null && paint != null) {
                    this.f47551b.v = spannableStringBuilder.length();
                    float measureText = paint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
                    int measuredWidth = this.f47551b.f47541h.getMeasuredWidth();
                    int lineCount = layout.getLineCount();
                    this.f47550a = lineCount;
                    if (lineCount == 2 && this.f47551b.r != null && this.f47551b.r.endsWith(this.f47551b.E) && paint.measureText(this.f47551b.r.substring(0, this.f47551b.r.length() - 4)) + measureText <= measuredWidth) {
                        this.f47550a = 1;
                        spannableStringBuilder.insert(0, (CharSequence) this.f47551b.r.substring(0, this.f47551b.r.length() - 4));
                        return spannableStringBuilder;
                    }
                    int i5 = this.f47550a;
                    if (i5 > 0) {
                        int lineEnd = layout.getLineEnd(i5 - 1) - layout.getLineStart(this.f47550a - 1);
                        spannableStringBuilder.insert(0, (CharSequence) this.f47551b.r);
                        if (lineEnd < this.f47551b.v) {
                            spannableStringBuilder.insert(this.f47551b.r.length(), (CharSequence) StringUtils.LF);
                        }
                    }
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

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
        F = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        G = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        H = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        I = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        J = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        K = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        L = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        M = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004);
        N = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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

    private void setTag(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, list) == null) {
            if ((list == null || list.isEmpty()) && k.isEmpty(this.q)) {
                this.f47540g.setVisibility(8);
                return;
            }
            this.f47540g.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f47540g;
            itemEllipsisView.setText(itemEllipsisView.iGetTextSpanCallback.c(null));
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (k.isEmpty(this.r) && k.isEmpty(this.s) && k.isEmpty(this.t)) {
                this.f47541h.setVisibility(8);
                return;
            }
            this.f47541h.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f47541h;
            itemEllipsisView.setText(itemEllipsisView.iGetTextSpanCallback.c(null));
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.w.reset();
            this.x.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            Path path = this.w;
            RectF rectF = this.x;
            int i2 = L;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            canvas.clipPath(this.w);
            super.draw(canvas);
        }
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.C : invokeV.intValue;
    }

    public void hideCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f47542i.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this, this.y);
            c.a.p0.s.u.c.d(this.f47539f).u(R.color.CAM_X0107);
            c.a.p0.s.u.c.d(this.f47540g).u(R.color.CAM_X0109);
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f47541h);
            d2.v(R.dimen.M_T_X001);
            d2.u(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47542i, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f47538e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.f47538e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f47538e.setPlaceHolder(1);
            this.k.changeSkinType();
            this.f47543j.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.B);
        }
    }

    public void setBackGroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.y = i2;
            onChangeSkinType();
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048583, this, tbRichTextEvaluateItemInfo, i2, str) == null) || tbRichTextEvaluateItemInfo == null) {
            return;
        }
        this.n = str;
        this.l = tbRichTextEvaluateItemInfo.getTitle();
        this.o = tbRichTextEvaluateItemInfo.getScore();
        this.p = tbRichTextEvaluateItemInfo.getTags();
        if (tbRichTextEvaluateItemInfo.getItem() != null) {
            this.m = tbRichTextEvaluateItemInfo.getItem().item_id.longValue();
            if (tbRichTextEvaluateItemInfo.getItem().apk_detail != null) {
                this.q = tbRichTextEvaluateItemInfo.getItem().apk_detail.version;
                this.r = tbRichTextEvaluateItemInfo.getItem().apk_detail.developer;
                this.s = tbRichTextEvaluateItemInfo.getItem().apk_detail.privacy_url;
                this.t = tbRichTextEvaluateItemInfo.getItem().apk_detail.authority_url;
            }
        }
        this.f47539f.setText(u(this.l));
        this.f47538e.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i2, false);
        setTag(tbRichTextEvaluateItemInfo.getTags());
        A();
        z(tbRichTextEvaluateItemInfo.getItem(), str);
        y(tbRichTextEvaluateItemInfo.getIconSize());
    }

    public void setHighLightText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.D = str;
        }
    }

    public void setIsShowRightBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.z = z;
            if (z && !this.A) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public void setOnClickListenerOfRightBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.f47542i.setOnClickListener(onClickListener);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.C = i2;
        }
    }

    public void setSizeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    public void showCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f47542i.setVisibility(0);
        }
    }

    public final SpannableStringBuilder u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            this.u = 0.0f;
            if (!TextUtils.isEmpty(this.D)) {
                UtilHelper.setSpan(spannableStringBuilder, str, this.D, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            }
            int length = spannableStringBuilder.length();
            double d2 = this.o;
            if (d2 > 0.0d && d2 <= 10.0d) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_star_16, R.color.CAM_X0305, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.a(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
                eMRichTextAnyIconSpan.c(UtilHelper.getDimenPixelSize(R.dimen.tbds7));
                eMRichTextAnyIconSpan.d(UtilHelper.getDimenPixelSize(R.dimen.tbds6));
                eMRichTextAnyIconSpan.e(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                String str2 = this.o + "";
                TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X09), SkinManager.getColorList(R.color.CAM_X0305), null);
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(textAppearanceSpan, spannableStringBuilder.length() - str2.length(), spannableStringBuilder.length(), 33);
            }
            this.u = this.f47539f.getPaint().measureText(spannableStringBuilder, length - 1, spannableStringBuilder.length());
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            b bVar = new b(this, 2921609);
            this.B = bVar;
            bVar.setTag(this.f47543j.getTag());
            this.B.setSelfListener(true);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f47539f.iGetTextSpanCallback = new c(this);
            this.f47540g.iGetTextSpanCallback = new d(this);
            this.f47541h.iGetTextSpanCallback = new e(this);
        }
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            this.E = context.getString(R.string.limited_company);
            LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
            this.f47538e = (TbImageView) findViewById(R.id.item_image);
            this.f47539f = (ItemEllipsisView) findViewById(R.id.first_info);
            this.f47540g = (ItemEllipsisView) findViewById(R.id.second_info);
            ItemEllipsisView itemEllipsisView = (ItemEllipsisView) findViewById(R.id.third_info);
            this.f47541h = itemEllipsisView;
            itemEllipsisView.setMovementMethod(ItemEllipsisView.a.a());
            this.f47542i = (ImageView) findViewById(R.id.bt_del);
            ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) findViewById(R.id.order_download_btn);
            this.f47543j = itemCardDownloadButton;
            itemCardDownloadButton.setClickCallback(new a(this));
            this.k = (TBSpecificationBtn) findViewById(R.id.order_or_download);
            c.a.p0.s.f0.n.c cVar = new c.a.p0.s.f0.n.c();
            cVar.o(R.color.CAM_X0304);
            this.k.setConfig(cVar);
            this.f47538e.setDrawCorner(true);
            this.f47538e.setConrers(15);
            this.f47538e.setRadiusById(R.string.J_X04);
            this.f47538e.setPlaceHolder(1);
            this.f47538e.setDrawBorder(true);
            onChangeSkinType();
            w();
        }
    }

    public final void y(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Double.valueOf(d2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f47538e.getLayoutParams();
            if (d2 == 1.0d) {
                layoutParams.width = F;
                layoutParams.height = G;
            } else if (d2 < 1.0d) {
                layoutParams.width = H;
                layoutParams.height = I;
            } else {
                layoutParams.width = J;
                layoutParams.height = K;
            }
            this.f47538e.setLayoutParams(layoutParams);
        }
    }

    public final void z(Item item, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, item, str) == null) || item == null) {
            return;
        }
        if (ItemCardHelper.t(item) && ItemCardHelper.m(item)) {
            this.A = true;
            this.f47543j.setData(item, this.C, str);
            this.f47543j.setVisibility(0);
            int objTypeByDownloadMode = this.f47543j.getObjTypeByDownloadMode();
            if (objTypeByDownloadMode > 0) {
                ItemCardHelper.o(this.C, item.item_id.longValue(), objTypeByDownloadMode, str);
            }
        } else {
            this.A = false;
            this.f47543j.setVisibility(8);
            if (this.z) {
                c.a.p0.s.f0.p.a aVar = new c.a.p0.s.f0.p.a(item, this.C, str);
                boolean equals = ItemCardHelper.f47833f.equals(item.button_name);
                ItemCardHelper.l(this.k, aVar);
                Item a2 = aVar.a();
                this.k.setText(a2.button_name);
                this.k.changeSkinType();
                int e2 = ItemCardHelper.e(a2.button_name);
                if (-1 != e2) {
                    int i2 = this.C;
                    long longValue = a2.item_id.longValue();
                    if (equals) {
                        e2 = 9;
                    }
                    ItemCardHelper.o(i2, longValue, e2, str);
                }
            }
        }
        setIsShowRightBtn(this.z);
    }

    /* loaded from: classes6.dex */
    public static class ItemEllipsisView extends EMTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public boolean f47544f;
        public b iGetTextSpanCallback;

        /* loaded from: classes6.dex */
        public static class a extends LinkMovementMethod {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f47545a;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public static a a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                    if (f47545a == null) {
                        f47545a = new a();
                    }
                    return f47545a;
                }
                return (a) invokeV.objValue;
            }

            @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
            public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, textView, spannable, motionEvent)) == null) {
                    int action = motionEvent.getAction();
                    if (action != 1 && action != 0) {
                        return Touch.onTouchEvent(textView, spannable, motionEvent);
                    }
                    int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                    int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                    int scrollX = x + textView.getScrollX();
                    int scrollY = y + textView.getScrollY();
                    Layout layout = textView.getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                    Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (objArr.length != 0) {
                        if (action == 1) {
                            objArr[0].onClick(textView);
                        } else if (action == 0) {
                            Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                        }
                        if (textView instanceof ItemEllipsisView) {
                            ((ItemEllipsisView) textView).f47544f = true;
                        }
                        return true;
                    }
                    Selection.removeSelection(spannable);
                    super.onTouchEvent(textView, spannable, motionEvent);
                    return false;
                }
                return invokeLLL.booleanValue;
            }
        }

        /* loaded from: classes6.dex */
        public interface b {
            int a();

            boolean b(int i2, Layout layout);

            SpannableStringBuilder c(Layout layout);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemEllipsisView(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47544f = false;
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int lineCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                super.onMeasure(i2, i3);
                if (this.iGetTextSpanCallback == null || (lineCount = (layout = getLayout()).getLineCount()) <= 1 || !this.iGetTextSpanCallback.b(lineCount, layout)) {
                    return;
                }
                setText(this.iGetTextSpanCallback.c(layout));
                int a2 = this.iGetTextSpanCallback.a();
                if (a2 <= 0 || lineCount == a2) {
                    return;
                }
                float f2 = a2 - lineCount;
                setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredHeight() + (getTextSize() * f2) + (getLineSpacingExtra() * f2)));
            }
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                this.f47544f = false;
                super.onTouchEvent(motionEvent);
                return this.f47544f;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f47544f) {
                    return true;
                }
                return super.performClick();
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemEllipsisView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
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
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f47544f = false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemEllipsisView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
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
                    super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f47544f = false;
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
        this.y = R.color.CAM_X0206;
        this.z = false;
        this.A = false;
        this.w = new Path();
        this.x = new RectF();
        x(context);
        v(context);
    }

    public void setData(Item item, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, item, i2, str) == null) || item == null) {
            return;
        }
        this.m = item.item_id.longValue();
        this.n = str;
        this.l = item.item_name;
        this.o = item.score.doubleValue();
        this.p = item.tags;
        ApkDetail apkDetail = item.apk_detail;
        if (apkDetail != null) {
            this.q = apkDetail.version;
            this.r = apkDetail.developer;
            this.s = apkDetail.privacy_url;
            this.t = apkDetail.authority_url;
        }
        this.f47539f.setText(u(this.l));
        this.f47538e.startLoad(item.icon_url, i2, false);
        setTag(item.tags);
        A();
        z(item, str);
        y(item.icon_size.doubleValue());
    }
}
