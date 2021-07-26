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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardDownloadButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
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
import d.a.d.a.j;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import java.util.List;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes3.dex */
public class ItemCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int I;
    public static final int J;
    public static final int K;
    public static final int L;
    public static final int M;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public String C;
    public String D;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f12477e;

    /* renamed from: f  reason: collision with root package name */
    public ItemEllipsisView f12478f;

    /* renamed from: g  reason: collision with root package name */
    public ItemEllipsisView f12479g;

    /* renamed from: h  reason: collision with root package name */
    public ItemEllipsisView f12480h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f12481i;
    public ItemCardDownloadButton j;
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

    /* loaded from: classes3.dex */
    public class a implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f12485a;

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
            this.f12485a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardDownloadButton.e
        public void onClick(int i2) {
            int objTypeByDownloadMode;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (objTypeByDownloadMode = this.f12485a.j.getObjTypeByDownloadMode()) <= 0) {
                return;
            }
            int i3 = this.f12485a.B;
            long j = this.f12485a.m;
            if (objTypeByDownloadMode == 2) {
                objTypeByDownloadMode = 1;
            }
            ItemCardHelper.n(i3, j, objTypeByDownloadMode, this.f12485a.n);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f12486a;

        public b(ItemCardView itemCardView) {
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
            this.f12486a = itemCardView;
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
                    return i2 > 1 && ((float) this.f12486a.l.length()) > (((float) layout.getLineEnd(0)) - this.f12486a.u) - 1.0f;
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
                TextPaint paint = this.f12486a.f12478f.getPaint();
                int measuredWidth = (int) (this.f12486a.f12478f.getMeasuredWidth() - this.f12486a.u);
                if (k.isEmpty(this.f12486a.l) || paint == null || measuredWidth <= 0) {
                    ItemCardView itemCardView = this.f12486a;
                    return itemCardView.u(itemCardView.l);
                }
                while (lineEnd > 0) {
                    if (this.f12486a.l.length() >= lineEnd) {
                        if (measuredWidth > paint.measureText(this.f12486a.l.substring(0, lineEnd - 1) + StringHelper.STRING_MORE)) {
                            break;
                        }
                    }
                    lineEnd--;
                }
                if (lineEnd > 0) {
                    return this.f12486a.u(this.f12486a.l.substring(0, lineEnd - 1) + StringHelper.STRING_MORE);
                }
                ItemCardView itemCardView2 = this.f12486a;
                return itemCardView2.u(itemCardView2.l);
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f12487a;

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
            this.f12487a = itemCardView;
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
                int measuredWidth = this.f12487a.f12479g.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = Integer.MAX_VALUE;
                }
                TextPaint paint = this.f12487a.f12479g.getPaint();
                if (paint == null) {
                    return spannableStringBuilder;
                }
                if (!k.isEmpty(this.f12487a.q)) {
                    measuredWidth -= (int) (ItemCardView.L + paint.measureText(((Object) this.f12487a.getContext().getText(R.string.item_version)) + this.f12487a.q));
                }
                if (ListUtils.getCount(this.f12487a.p) > 0) {
                    for (int i2 = 0; i2 < this.f12487a.p.size(); i2++) {
                        if (!k.isEmpty((String) this.f12487a.p.get(i2))) {
                            float measureText = measuredWidth - paint.measureText(((String) this.f12487a.p.get(i2)) + " ");
                            if (measureText <= 0.0f) {
                                break;
                            }
                            spannableStringBuilder.append((CharSequence) this.f12487a.p.get(i2));
                            spannableStringBuilder.append((CharSequence) " ");
                            measuredWidth = (int) measureText;
                        }
                    }
                }
                if (!k.isEmpty(this.f12487a.q)) {
                    if (spannableStringBuilder.length() > 1) {
                        spannableStringBuilder.setSpan(new d.a.p0.s.f0.r.b(ItemCardView.L), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    }
                    spannableStringBuilder.append(this.f12487a.getContext().getText(R.string.item_version));
                    spannableStringBuilder.append((CharSequence) this.f12487a.q);
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f12488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f12489b;

        /* loaded from: classes3.dex */
        public class a extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f12490e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12490e = dVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f12490e.f12489b.s) && (j.a(this.f12490e.f12489b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f12490e.f12489b.getContext()), new String[]{this.f12490e.f12489b.s});
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

        /* loaded from: classes3.dex */
        public class b extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f12491e;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12491e = dVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f12491e.f12489b.t) && (j.a(this.f12491e.f12489b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f12491e.f12489b.getContext()), new String[]{this.f12491e.f12489b.t});
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
            this.f12489b = itemCardView;
            this.f12488a = 1;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12488a : invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean b(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, layout)) == null) {
                if (layout != null) {
                    if (i2 == 2 && this.f12489b.r != null && this.f12489b.r.endsWith(this.f12489b.D)) {
                        return true;
                    }
                    if (i2 > 0) {
                        int i3 = i2 - 1;
                        return layout.getLineEnd(i3) - layout.getLineStart(i3) < this.f12489b.v;
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
                if (!k.isEmpty(this.f12489b.s) || !k.isEmpty(this.f12489b.t)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " |");
                    int i2 = length + 1;
                    spannableStringBuilder.setSpan(new d.a.p0.s.f0.r.b(ItemCardView.M), length, i2, 33);
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X10), new ColorStateList(new int[][]{new int[0]}, new int[]{d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0108), d.a.p0.s.u.a.a(R.string.A_X10))}), null), i2, length + 2, 33);
                    if (!k.isEmpty(this.f12489b.s)) {
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f12489b.getContext().getString(R.string.item_download_privacy));
                        int i3 = length2 + 1;
                        spannableStringBuilder.setSpan(new d.a.p0.s.f0.r.b(ItemCardView.M), length2, i3, 33);
                        spannableStringBuilder.setSpan(new a(this), i3, length2 + 3, 33);
                    }
                    if (!k.isEmpty(this.f12489b.t)) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f12489b.getContext().getString(R.string.item_download_authority));
                        int i4 = length3 + 1;
                        spannableStringBuilder.setSpan(new d.a.p0.s.f0.r.b(ItemCardView.M), length3, i4, 33);
                        spannableStringBuilder.setSpan(new b(this), i4, length3 + 3, 33);
                    }
                }
                if (layout == null) {
                    spannableStringBuilder.insert(0, (CharSequence) this.f12489b.r);
                    return spannableStringBuilder;
                }
                TextPaint paint = this.f12489b.f12480h.getPaint();
                if (this.f12489b.r != null && paint != null) {
                    this.f12489b.v = spannableStringBuilder.length();
                    float measureText = paint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
                    int measuredWidth = this.f12489b.f12480h.getMeasuredWidth();
                    int lineCount = layout.getLineCount();
                    this.f12488a = lineCount;
                    if (lineCount == 2 && this.f12489b.r != null && this.f12489b.r.endsWith(this.f12489b.D) && paint.measureText(this.f12489b.r.substring(0, this.f12489b.r.length() - 4)) + measureText <= measuredWidth) {
                        this.f12488a = 1;
                        spannableStringBuilder.insert(0, (CharSequence) this.f12489b.r.substring(0, this.f12489b.r.length() - 4));
                        return spannableStringBuilder;
                    }
                    int i5 = this.f12488a;
                    if (i5 > 0) {
                        int lineEnd = layout.getLineEnd(i5 - 1) - layout.getLineStart(this.f12488a - 1);
                        spannableStringBuilder.insert(0, (CharSequence) this.f12489b.r);
                        if (lineEnd < this.f12489b.v) {
                            spannableStringBuilder.insert(this.f12489b.r.length(), (CharSequence) "\n");
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
        E = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        F = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        G = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        H = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        I = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        J = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        K = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        L = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004);
        M = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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
                this.f12479g.setVisibility(8);
                return;
            }
            this.f12479g.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f12479g;
            itemEllipsisView.setText(itemEllipsisView.f12482f.c(null));
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (k.isEmpty(this.r) && k.isEmpty(this.s) && k.isEmpty(this.t)) {
                this.f12480h.setVisibility(8);
                return;
            }
            this.f12480h.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f12480h;
            itemEllipsisView.setText(itemEllipsisView.f12482f.c(null));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12481i.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.w.reset();
            this.x.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            Path path = this.w;
            RectF rectF = this.x;
            int i2 = K;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            canvas.clipPath(this.w);
            super.draw(canvas);
        }
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.B : invokeV.intValue;
    }

    public void setBackGroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.y = i2;
            x();
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048581, this, tbRichTextEvaluateItemInfo, i2, str) == null) || tbRichTextEvaluateItemInfo == null) {
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
        this.f12478f.setText(u(this.l));
        this.f12477e.M(tbRichTextEvaluateItemInfo.getIconUrl(), i2, false);
        setTag(tbRichTextEvaluateItemInfo.getTags());
        A();
        z(tbRichTextEvaluateItemInfo.getItem(), str);
        y(tbRichTextEvaluateItemInfo.getIconSize());
    }

    public void setHighLightText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.C = str;
        }
    }

    public void setIsShowRightBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f12481i.setOnClickListener(onClickListener);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setSizeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    public final SpannableStringBuilder u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            this.u = 0.0f;
            if (!TextUtils.isEmpty(this.C)) {
                UtilHelper.setSpan(spannableStringBuilder, str, this.C, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
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
            this.u = this.f12478f.getPaint().measureText(spannableStringBuilder, length - 1, spannableStringBuilder.length());
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f12478f.f12482f = new b(this);
            this.f12479g.f12482f = new c(this);
            this.f12480h.f12482f = new d(this);
        }
    }

    public final void w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.D = context.getString(R.string.limited_company);
            LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
            this.f12477e = (TbImageView) findViewById(R.id.item_image);
            this.f12478f = (ItemEllipsisView) findViewById(R.id.first_info);
            this.f12479g = (ItemEllipsisView) findViewById(R.id.second_info);
            ItemEllipsisView itemEllipsisView = (ItemEllipsisView) findViewById(R.id.third_info);
            this.f12480h = itemEllipsisView;
            itemEllipsisView.setMovementMethod(ItemEllipsisView.a.a());
            this.f12481i = (ImageView) findViewById(R.id.bt_del);
            ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) findViewById(R.id.order_download_btn);
            this.j = itemCardDownloadButton;
            itemCardDownloadButton.setClickCallback(new a(this));
            this.k = (TBSpecificationBtn) findViewById(R.id.order_or_download);
            d.a.p0.s.f0.n.c cVar = new d.a.p0.s.f0.n.c();
            cVar.o(R.color.CAM_X0304);
            this.k.setConfig(cVar);
            this.f12477e.setDrawCorner(true);
            this.f12477e.setConrers(15);
            this.f12477e.setRadiusById(R.string.J_X04);
            this.f12477e.setPlaceHolder(1);
            this.f12477e.setDrawBorder(true);
            x();
            v();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SkinManager.setBackgroundColor(this, this.y);
            d.a.p0.s.u.c.d(this.f12478f).t(R.color.CAM_X0107);
            d.a.p0.s.u.c.d(this.f12479g).t(R.color.CAM_X0109);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f12480h);
            d2.u(R.dimen.M_T_X001);
            d2.t(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12481i, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f12477e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.f12477e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f12477e.setPlaceHolder(1);
            this.k.k();
            this.j.s();
        }
    }

    public final void y(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Double.valueOf(d2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12477e.getLayoutParams();
            if (d2 == 1.0d) {
                layoutParams.width = E;
                layoutParams.height = F;
            } else if (d2 < 1.0d) {
                layoutParams.width = G;
                layoutParams.height = H;
            } else {
                layoutParams.width = I;
                layoutParams.height = J;
            }
            this.f12477e.setLayoutParams(layoutParams);
        }
    }

    public final void z(Item item, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, item, str) == null) || item == null) {
            return;
        }
        if (ItemCardHelper.t(item) && ItemCardHelper.m(item)) {
            this.A = true;
            this.j.setData(item);
            this.j.setVisibility(0);
            int objTypeByDownloadMode = this.j.getObjTypeByDownloadMode();
            if (objTypeByDownloadMode > 0) {
                ItemCardHelper.o(this.B, item.item_id.longValue(), objTypeByDownloadMode != 2 ? objTypeByDownloadMode : 1, str);
            }
        } else {
            this.A = false;
            this.j.setVisibility(8);
            if (this.z) {
                d.a.p0.s.f0.p.a aVar = new d.a.p0.s.f0.p.a(item, this.B, str);
                ItemCardHelper.l(this.k, aVar);
                Item a2 = aVar.a();
                this.k.setText(a2.button_name);
                this.k.k();
                int e2 = ItemCardHelper.e(a2.button_name);
                if (-1 != e2) {
                    ItemCardHelper.o(this.B, a2.item_id.longValue(), e2, str);
                }
            }
        }
        setIsShowRightBtn(this.z);
    }

    /* loaded from: classes3.dex */
    public static class ItemEllipsisView extends EMTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public b f12482f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f12483g;

        /* loaded from: classes3.dex */
        public static class a extends LinkMovementMethod {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f12484a;
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
                    if (f12484a == null) {
                        f12484a = new a();
                    }
                    return f12484a;
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
                            ((ItemEllipsisView) textView).f12483g = true;
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

        /* loaded from: classes3.dex */
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
            this.f12483g = false;
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int lineCount;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                super.onMeasure(i2, i3);
                if (this.f12482f == null || (lineCount = (layout = getLayout()).getLineCount()) <= 1 || !this.f12482f.b(lineCount, layout)) {
                    return;
                }
                setText(this.f12482f.c(layout));
                int a2 = this.f12482f.a();
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
                this.f12483g = false;
                super.onTouchEvent(motionEvent);
                return this.f12483g;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f12483g) {
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
            this.f12483g = false;
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
            this.f12483g = false;
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
        w(context);
    }

    public void setData(Item item, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048582, this, item, i2, str) == null) || item == null) {
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
        this.f12478f.setText(u(this.l));
        this.f12477e.M(item.icon_url, i2, false);
        setTag(item.tags);
        A();
        z(item, str);
        y(item.icon_size.doubleValue());
    }
}
