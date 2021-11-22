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
import b.a.e.a.j;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
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
/* loaded from: classes8.dex */
public class ItemCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVALUATE_STYLE = 1;
    public static final int M;
    public static final int N;
    public static final int NORMA_STYLE = 0;
    public static final int O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static final int T;
    public static final int U;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public CustomMessageListener G;
    public boolean H;
    public int I;
    public String J;
    public int K;
    public String L;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f46114e;

    /* renamed from: f  reason: collision with root package name */
    public ItemEllipsisView f46115f;

    /* renamed from: g  reason: collision with root package name */
    public ItemEllipsisView f46116g;

    /* renamed from: h  reason: collision with root package name */
    public ItemEllipsisView f46117h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f46118i;
    public ItemCardDownloadButton j;
    public TBSpecificationBtn k;
    public ProgressButton l;
    public TiePlusHelper m;
    public String n;
    public long o;
    public String p;
    public double q;
    public List<String> r;
    public String s;
    public String t;
    public String u;
    public String v;
    public float w;
    public int x;
    public Path y;
    public RectF z;

    /* loaded from: classes8.dex */
    public class a implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f46122a;

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
            this.f46122a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.f46122a.j.getObjTypeByDownloadMode();
                int a2 = b.a.q0.s.g0.p.c.a(this.f46122a.j.getCurrentItem().buttonLinkType.intValue(), this.f46122a.j.getCurrentItem().apkDetail != null ? this.f46122a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a2 == 4) {
                    return;
                }
                ItemCardHelper.p(this.f46122a.I, this.f46122a.o, objTypeByDownloadMode, this.f46122a.p, a2, "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f46123a;

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
            this.f46123a = itemCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.f46123a.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode <= 0 || this.f46123a.H) {
                    return;
                }
                ItemCardHelper.p(this.f46123a.I, this.f46123a.o, objTypeByDownloadMode, this.f46123a.p, b.a.q0.s.g0.p.c.a(this.f46123a.j.getCurrentItem().buttonLinkType.intValue(), this.f46123a.j.getCurrentItem().apkDetail != null ? this.f46123a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0), str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f46124a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f46125b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ItemData f46126c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f46127d;

        public c(ItemCardView itemCardView, int i2, int i3, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView, Integer.valueOf(i2), Integer.valueOf(i3), itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46127d = itemCardView;
            this.f46124a = i2;
            this.f46125b = i3;
            this.f46126c = itemData;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            int objTypeByDownloadMode;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (objTypeByDownloadMode = this.f46127d.j.getObjTypeByDownloadMode()) <= 0) {
                return;
            }
            ItemCardHelper.f(this.f46124a, this.f46125b, objTypeByDownloadMode, 1, this.f46126c.mTitle, true);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46128e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46129f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ItemData f46130g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f46131h;

        public d(ItemCardView itemCardView, int i2, int i3, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView, Integer.valueOf(i2), Integer.valueOf(i3), itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46131h = itemCardView;
            this.f46128e = i2;
            this.f46129f = i3;
            this.f46130g = itemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.f(this.f46128e, this.f46129f, this.f46131h.getTiePlusButtonState(), 2, this.f46130g.mTitle, true);
                this.f46131h.m.onClick(view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f46132a;

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
            this.f46132a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46132a.K : invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                if (z) {
                    ItemCardView itemCardView = this.f46132a;
                    return itemCardView.z(itemCardView.n);
                }
                int lineStart = layout.getLineStart(this.f46132a.K - 1);
                int lineEnd = layout.getLineEnd(this.f46132a.K - 1);
                TextPaint paint = this.f46132a.f46115f.getPaint();
                int measuredWidth = (int) (this.f46132a.f46115f.getMeasuredWidth() - this.f46132a.w);
                if (k.isEmpty(this.f46132a.n) || paint == null || measuredWidth <= 0) {
                    ItemCardView itemCardView2 = this.f46132a;
                    return itemCardView2.z(itemCardView2.n);
                }
                while (lineEnd > 0) {
                    if (this.f46132a.n.length() >= lineEnd) {
                        if (measuredWidth > paint.measureText(this.f46132a.n.substring(lineStart, lineEnd - 1) + "...")) {
                            break;
                        }
                    }
                    lineEnd--;
                }
                if (lineEnd > 0) {
                    return this.f46132a.z(this.f46132a.n.substring(0, lineEnd - 1) + "...");
                }
                ItemCardView itemCardView3 = this.f46132a;
                return itemCardView3.z(itemCardView3.n);
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean c(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, layout)) == null) ? layout != null && i2 > this.f46132a.K : invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder d(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layout)) == null) {
                int lineCount = layout.getLineCount();
                if (lineCount != 0 && lineCount != 1) {
                    TextPaint paint = this.f46132a.f46115f.getPaint();
                    int measuredWidth = this.f46132a.f46115f.getWidth() == 0 ? this.f46132a.f46115f.getMeasuredWidth() : this.f46132a.f46115f.getWidth();
                    float measureText = paint.measureText(this.f46132a.n.substring(layout.getLineStart(lineCount - 2)));
                    float f2 = measuredWidth;
                    if (measureText <= f2 && measureText > f2 - this.f46132a.w) {
                        ItemCardView itemCardView = this.f46132a;
                        return itemCardView.A(itemCardView.n, true);
                    }
                }
                return null;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f46133a;

        public f(ItemCardView itemCardView) {
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
            this.f46133a = itemCardView;
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
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int measuredWidth = this.f46133a.f46116g.getWidth() == 0 ? this.f46133a.f46116g.getMeasuredWidth() : this.f46133a.f46116g.getWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = Integer.MAX_VALUE;
                }
                TextPaint paint = this.f46133a.f46116g.getPaint();
                if (paint == null) {
                    return spannableStringBuilder;
                }
                if (!k.isEmpty(this.f46133a.s)) {
                    measuredWidth -= (int) (ItemCardView.T + paint.measureText(((Object) this.f46133a.getContext().getText(R.string.item_version)) + this.f46133a.s));
                }
                if (ListUtils.getCount(this.f46133a.r) > 0) {
                    for (int i2 = 0; i2 < this.f46133a.r.size(); i2++) {
                        if (!k.isEmpty((String) this.f46133a.r.get(i2))) {
                            float measureText = measuredWidth - paint.measureText(((String) this.f46133a.r.get(i2)) + " ");
                            if (measureText <= 0.0f) {
                                break;
                            }
                            spannableStringBuilder.append((CharSequence) this.f46133a.r.get(i2));
                            spannableStringBuilder.append((CharSequence) " ");
                            measuredWidth = (int) measureText;
                        }
                    }
                }
                if (!k.isEmpty(this.f46133a.s)) {
                    if (spannableStringBuilder.length() > 1) {
                        spannableStringBuilder.setSpan(new b.a.q0.s.g0.r.b(ItemCardView.T), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    }
                    spannableStringBuilder.append(this.f46133a.getContext().getText(R.string.item_version));
                    spannableStringBuilder.append((CharSequence) this.f46133a.s);
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean c(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, layout)) == null) ? i2 > 1 : invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder d(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layout)) == null) {
                return null;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46134a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f46135b;

        /* loaded from: classes8.dex */
        public class a extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f46136e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46136e = gVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f46136e.f46135b.u) && (j.a(this.f46136e.f46135b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f46136e.f46135b.getContext()), new String[]{this.f46136e.f46135b.u});
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

        /* loaded from: classes8.dex */
        public class b extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f46137e;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46137e = gVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f46137e.f46135b.v) && (j.a(this.f46137e.f46135b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f46137e.f46135b.getContext()), new String[]{this.f46137e.f46135b.v});
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

        public g(ItemCardView itemCardView) {
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
            this.f46135b = itemCardView;
            this.f46134a = 1;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46134a : invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!k.isEmpty(this.f46135b.u) || !k.isEmpty(this.f46135b.v)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " |");
                    int i2 = length + 1;
                    spannableStringBuilder.setSpan(new b.a.q0.s.g0.r.b(ItemCardView.U), length, i2, 33);
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X10), new ColorStateList(new int[][]{new int[0]}, new int[]{b.a.r0.m3.c.a(SkinManager.getColor(R.color.CAM_X0108), b.a.q0.s.u.a.a(R.string.A_X10))}), null), i2, length + 2, 33);
                    if (!k.isEmpty(this.f46135b.u)) {
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f46135b.getContext().getString(R.string.item_download_privacy));
                        int i3 = length2 + 1;
                        spannableStringBuilder.setSpan(new b.a.q0.s.g0.r.b(ItemCardView.U), length2, i3, 33);
                        spannableStringBuilder.setSpan(new a(this), i3, length2 + 3, 33);
                    }
                    if (!k.isEmpty(this.f46135b.v)) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f46135b.getContext().getString(R.string.item_download_authority));
                        int i4 = length3 + 1;
                        spannableStringBuilder.setSpan(new b.a.q0.s.g0.r.b(ItemCardView.U), length3, i4, 33);
                        spannableStringBuilder.setSpan(new b(this), i4, length3 + 3, 33);
                    }
                }
                if (layout == null) {
                    spannableStringBuilder.insert(0, (CharSequence) this.f46135b.t);
                    return spannableStringBuilder;
                }
                TextPaint paint = this.f46135b.f46117h.getPaint();
                if (this.f46135b.t != null && paint != null) {
                    this.f46135b.x = spannableStringBuilder.length();
                    float measureText = paint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
                    int measuredWidth = this.f46135b.f46117h.getMeasuredWidth();
                    int lineCount = layout.getLineCount();
                    this.f46134a = lineCount;
                    if (lineCount == 2 && this.f46135b.t != null && this.f46135b.t.endsWith(this.f46135b.L) && paint.measureText(this.f46135b.t.substring(0, this.f46135b.t.length() - 4)) + measureText <= measuredWidth) {
                        this.f46134a = 1;
                        spannableStringBuilder.insert(0, (CharSequence) this.f46135b.t.substring(0, this.f46135b.t.length() - 4));
                        return spannableStringBuilder;
                    }
                    int i5 = this.f46134a;
                    if (i5 > 0) {
                        int lineEnd = layout.getLineEnd(i5 - 1) - layout.getLineStart(this.f46134a - 1);
                        spannableStringBuilder.insert(0, (CharSequence) this.f46135b.t);
                        if (lineEnd < this.f46135b.x) {
                            spannableStringBuilder.insert(this.f46135b.t.length(), (CharSequence) StringUtils.LF);
                        }
                    }
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean c(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, layout)) == null) {
                if (layout != null) {
                    if (i2 == 2 && this.f46135b.t != null && this.f46135b.t.endsWith(this.f46135b.L)) {
                        return true;
                    }
                    if (i2 > 0) {
                        int i3 = i2 - 1;
                        return layout.getLineEnd(i3) - layout.getLineStart(i3) < this.f46135b.x;
                    }
                    return false;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder d(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layout)) == null) {
                return null;
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
        M = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        N = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        O = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        P = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        Q = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        R = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        S = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        T = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004);
        U = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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

    /* JADX INFO: Access modifiers changed from: private */
    public int getTiePlusButtonState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            ProgressButton progressButton = this.l;
            if (progressButton == null || progressButton.getVisibility() != 0) {
                return -1;
            }
            byte byteValue = ((Byte) this.l.getTag()).byteValue();
            if (byteValue != 0) {
                if (byteValue != 1) {
                    if (byteValue != 2) {
                        if (byteValue != 3) {
                            return byteValue != 4 ? -1 : 5;
                        }
                        return 7;
                    }
                    return 4;
                }
                return 8;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    private void setMaxLinesByItemButtonName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
            if (ItemCardHelper.f46390b.equals(str)) {
                this.K = 1;
            } else {
                this.K = 2;
            }
            this.f46115f.f46120g = this.K;
        }
    }

    private void setTag(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, list) == null) {
            if ((list == null || list.isEmpty() || !E(list)) && k.isEmpty(this.s)) {
                this.f46116g.setVisibility(8);
                return;
            }
            this.f46116g.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f46116g;
            itemEllipsisView.setText(itemEllipsisView.iGetTextSpanCallback.b(null, false));
        }
    }

    public final SpannableStringBuilder A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(k.isEmpty(str) ? "" : str);
            this.w = 0.0f;
            if (!TextUtils.isEmpty(this.J)) {
                UtilHelper.setSpan(spannableStringBuilder, str, this.J, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            }
            double d2 = this.q;
            if (d2 > 0.0d && d2 <= 10.0d) {
                int length = spannableStringBuilder.length();
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_small_star, R.color.CAM_X0305, EMRichTextAnyIconSpan.IconType.WEBP);
                if (z) {
                    eMRichTextAnyIconSpan.b(-UtilHelper.getDimenPixelSize(R.dimen.tbds2));
                } else {
                    eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
                }
                eMRichTextAnyIconSpan.d(UtilHelper.getDimenPixelSize(R.dimen.tbds7));
                eMRichTextAnyIconSpan.e(UtilHelper.getDimenPixelSize(R.dimen.tbds6));
                eMRichTextAnyIconSpan.f(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
                if (z) {
                    spannableStringBuilder.append((CharSequence) "\n ");
                } else {
                    spannableStringBuilder.append((CharSequence) " ");
                }
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                String str2 = this.q + "";
                TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X09), SkinManager.getColorList(R.color.CAM_X0305), null);
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(textAppearanceSpan, spannableStringBuilder.length() - str2.length(), spannableStringBuilder.length(), 33);
                this.w = this.f46115f.getPaint().measureText(spannableStringBuilder, length == 0 ? 0 : length - 1, spannableStringBuilder.length());
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            b bVar = new b(this, 2921609);
            this.G = bVar;
            bVar.setTag(this.j.getTag());
            this.G.setSelfListener(true);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f46115f.iGetTextSpanCallback = new e(this);
            ItemEllipsisView itemEllipsisView = this.f46115f;
            itemEllipsisView.f46120g = itemEllipsisView.iGetTextSpanCallback.a();
            this.f46116g.iGetTextSpanCallback = new f(this);
            this.f46117h.iGetTextSpanCallback = new g(this);
        }
    }

    public final void D(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.L = context.getString(R.string.limited_company);
            LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
            this.f46114e = (TbImageView) findViewById(R.id.item_image);
            this.f46115f = (ItemEllipsisView) findViewById(R.id.first_info);
            this.f46116g = (ItemEllipsisView) findViewById(R.id.second_info);
            ItemEllipsisView itemEllipsisView = (ItemEllipsisView) findViewById(R.id.third_info);
            this.f46117h = itemEllipsisView;
            itemEllipsisView.setMovementMethod(ItemEllipsisView.a.a());
            this.f46118i = (ImageView) findViewById(R.id.bt_del);
            ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) findViewById(R.id.order_download_btn);
            this.j = itemCardDownloadButton;
            itemCardDownloadButton.setClickCallback(new a(this));
            this.k = (TBSpecificationBtn) findViewById(R.id.order_or_download);
            b.a.q0.s.g0.n.c cVar = new b.a.q0.s.g0.n.c();
            cVar.p(R.color.CAM_X0304);
            this.k.setConfig(cVar);
            this.f46114e.setDrawCorner(true);
            this.f46114e.setConrers(15);
            this.f46114e.setRadiusById(this.D);
            this.f46114e.setPlaceHolder(1);
            this.f46114e.setDrawBorder(true);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tie_plus_download_btn);
            this.l = progressButton;
            progressButton.setUseLongText(false);
            this.l.setVisibility(8);
            TiePlusHelper tiePlusHelper = new TiePlusHelper(getContext());
            this.m = tiePlusHelper;
            tiePlusHelper.g(this.l);
            onChangeSkinType();
            C();
        }
    }

    public final boolean E(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void F(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f46114e.getLayoutParams();
            if (d2 == 1.0d || d2 <= 0.0d) {
                layoutParams.width = M;
                layoutParams.height = N;
            } else if (d2 < 1.0d) {
                layoutParams.width = O;
                layoutParams.height = P;
            } else {
                layoutParams.width = Q;
                layoutParams.height = R;
            }
            this.f46114e.setLayoutParams(layoutParams);
        }
    }

    public final void G(ItemData itemData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, itemData, str) == null) || itemData == null) {
            return;
        }
        this.l.setVisibility(8);
        if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
            this.F = true;
            this.j.setData(itemData, this.I, str);
            this.j.setVisibility(0);
            int objTypeByDownloadMode = this.j.getObjTypeByDownloadMode();
            if (objTypeByDownloadMode > 0 && !this.H) {
                ItemCardHelper.r(this.I, itemData.itemId, objTypeByDownloadMode, str);
            }
        } else {
            this.F = false;
            this.j.setVisibility(8);
            if (this.E) {
                b.a.q0.s.g0.p.a aVar = new b.a.q0.s.g0.p.a(itemData, this.I, str);
                boolean equals = ItemCardHelper.f46394f.equals(itemData.buttonName);
                ItemCardHelper.n(this.k, aVar);
                ItemData a2 = aVar.a();
                this.k.setText(a2.buttonName);
                this.k.changeSkinType();
                int e2 = ItemCardHelper.e(a2.buttonName);
                if (-1 != e2 && !this.H) {
                    int i2 = this.I;
                    long j = a2.itemId;
                    if (equals) {
                        e2 = 9;
                    }
                    ItemCardHelper.r(i2, j, e2, str);
                }
                itemData = a2;
            }
        }
        setMaxLinesByItemButtonName(itemData.buttonName);
        setIsShowRightBtn(this.E);
    }

    public final void H(Item item, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, item, str) == null) || item == null) {
            return;
        }
        ItemData itemData = new ItemData();
        itemData.parseProto(item);
        G(itemData, str);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (k.isEmpty(this.t) && k.isEmpty(this.u) && k.isEmpty(this.v)) {
                this.f46117h.setVisibility(8);
                return;
            }
            this.f46117h.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f46117h;
            itemEllipsisView.setText(itemEllipsisView.iGetTextSpanCallback.b(null, false));
        }
    }

    public final void J(ItemData itemData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, itemData, i2) == null) || itemData == null) {
            return;
        }
        if ((ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) || i2 == 1) {
            this.l.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            TiePlusHelper tiePlusHelper = this.m;
            tiePlusHelper.B(itemData.appId);
            tiePlusHelper.M(itemData.buttonLink);
            tiePlusHelper.P(itemData.pkgName);
            TiePlusHelper tiePlusHelper2 = this.m;
            tiePlusHelper2.Z(tiePlusHelper2.p(), this.m.n(), getContext(), this.l);
            this.m.O(itemData);
        } else {
            this.F = false;
            this.j.setVisibility(8);
            this.l.setVisibility(8);
            if (this.E) {
                b.a.q0.s.g0.p.a aVar = new b.a.q0.s.g0.p.a(itemData, this.I, "");
                ItemCardHelper.n(this.k, aVar);
                itemData = aVar.a();
                this.k.setText(itemData.buttonName);
                this.k.changeSkinType();
            }
            setIsShowRightBtn(this.E);
        }
        setMaxLinesByItemButtonName(itemData.buttonName);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.y.reset();
            this.z.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            Path path = this.y;
            RectF rectF = this.z;
            int i2 = this.B;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            canvas.clipPath(this.y);
            super.draw(canvas);
        }
    }

    public int getButtonState(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, itemData)) == null) {
            if (itemData == null) {
                return -1;
            }
            ProgressButton progressButton = this.l;
            if (progressButton != null && progressButton.getVisibility() == 0) {
                return getTiePlusButtonState();
            }
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                return this.j.getObjTypeByDownloadMode();
            }
            boolean equals = ItemCardHelper.f46394f.equals(itemData.buttonName);
            int e2 = ItemCardHelper.e(itemData.buttonName);
            if (equals) {
                return 9;
            }
            return e2;
        }
        return invokeL.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.I : invokeV.intValue;
    }

    public void hideCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f46118i.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SkinManager.setBackgroundColor(this, this.A);
            b.a.q0.s.u.c.d(this.f46115f).v(this.C);
            b.a.q0.s.u.c.d(this.f46116g).v(R.color.CAM_X0109);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f46117h);
            d2.w(R.dimen.M_T_X001);
            d2.v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f46118i, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f46114e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.f46114e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f46114e.setPlaceHolder(1);
            this.k.changeSkinType();
            this.j.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = "";
            this.A = R.color.CAM_X0206;
            this.B = S;
            this.C = R.color.CAM_X0107;
            this.D = R.string.J_X04;
            this.E = false;
            this.F = false;
            this.H = false;
            this.K = 2;
            b.a.q0.s.g0.n.c cVar = new b.a.q0.s.g0.n.c();
            cVar.p(R.color.CAM_X0304);
            this.k.setConfig(cVar);
            this.f46114e.setDrawCorner(true);
            this.f46114e.setConrers(15);
            this.f46114e.setRadiusById(this.D);
            this.f46114e.setPlaceHolder(1);
            this.f46114e.setDrawBorder(true);
            this.l.setUseLongText(false);
            this.l.setVisibility(8);
        }
    }

    public void setBackGroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.A = i2;
            onChangeSkinType();
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048599, this, tbRichTextEvaluateItemInfo, i2, str) == null) || tbRichTextEvaluateItemInfo == null) {
            return;
        }
        this.p = str;
        this.n = tbRichTextEvaluateItemInfo.getTitle();
        this.q = tbRichTextEvaluateItemInfo.getScore();
        this.r = tbRichTextEvaluateItemInfo.getTags();
        if (tbRichTextEvaluateItemInfo.getItem() != null) {
            this.o = tbRichTextEvaluateItemInfo.getItem().item_id.longValue();
            if (tbRichTextEvaluateItemInfo.getItem().apk_detail != null) {
                this.s = tbRichTextEvaluateItemInfo.getItem().apk_detail.version;
                this.t = tbRichTextEvaluateItemInfo.getItem().apk_detail.developer;
                this.u = tbRichTextEvaluateItemInfo.getItem().apk_detail.privacy_url;
                this.v = tbRichTextEvaluateItemInfo.getItem().apk_detail.authority_url;
            }
        }
        this.f46115f.setText(z(this.n));
        this.f46114e.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i2, false);
        setTag(tbRichTextEvaluateItemInfo.getTags());
        I();
        H(tbRichTextEvaluateItemInfo.getItem(), str);
        F(tbRichTextEvaluateItemInfo.getIconSize());
    }

    public void setFirstLineTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.C = i2;
            onChangeSkinType();
        }
    }

    public void setHighLightText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.J = str;
        }
    }

    public void setIsShowRightBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.E = z;
            if (z && !this.F) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public void setItemImageViewRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.D = i2;
            TbImageView tbImageView = this.f46114e;
            if (tbImageView != null) {
                tbImageView.setRadiusById(i2);
            }
        }
    }

    public void setOnClickListenerOfRightBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.f46118i.setOnClickListener(onClickListener);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.I = i2;
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.B = i2;
            postInvalidate();
        }
    }

    public void setSizeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
        }
    }

    public void showCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f46118i.setVisibility(0);
        }
    }

    public final SpannableStringBuilder z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) ? A(str, false) : (SpannableStringBuilder) invokeL.objValue;
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

    /* loaded from: classes8.dex */
    public static class ItemEllipsisView extends EMTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public boolean f46119f;

        /* renamed from: g  reason: collision with root package name */
        public int f46120g;
        public b iGetTextSpanCallback;

        /* loaded from: classes8.dex */
        public static class a extends LinkMovementMethod {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f46121a;
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
                    if (f46121a == null) {
                        f46121a = new a();
                    }
                    return f46121a;
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
                            ((ItemEllipsisView) textView).f46119f = true;
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

        /* loaded from: classes8.dex */
        public interface b {
            int a();

            SpannableStringBuilder b(Layout layout, boolean z);

            boolean c(int i2, Layout layout);

            SpannableStringBuilder d(Layout layout);
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
            this.f46119f = false;
            this.f46120g = 1;
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                super.onMeasure(i2, i3);
                if (this.iGetTextSpanCallback != null) {
                    Layout layout = getLayout();
                    int lineCount = layout.getLineCount();
                    if (lineCount > this.f46120g) {
                        if (layout.getText().toString().contains(StringUtils.LF)) {
                            setText(this.iGetTextSpanCallback.b(layout, true));
                            return;
                        } else if (this.iGetTextSpanCallback.c(lineCount, layout)) {
                            setText(this.iGetTextSpanCallback.b(layout, false));
                            int a2 = this.iGetTextSpanCallback.a();
                            if (a2 <= 0 || lineCount == a2) {
                                return;
                            }
                            float f2 = a2 - lineCount;
                            setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredHeight() + (getTextSize() * f2) + (getLineSpacingExtra() * f2)));
                            return;
                        } else {
                            return;
                        }
                    }
                    SpannableStringBuilder d2 = this.iGetTextSpanCallback.d(layout);
                    if (d2 != null) {
                        setText(d2);
                    }
                }
            }
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                this.f46119f = false;
                super.onTouchEvent(motionEvent);
                return this.f46119f;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f46119f) {
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
            this.f46119f = false;
            this.f46120g = 1;
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
            this.f46119f = false;
            this.f46120g = 1;
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
        this.A = R.color.CAM_X0206;
        this.B = S;
        this.C = R.color.CAM_X0107;
        this.D = R.string.J_X04;
        this.E = false;
        this.F = false;
        this.H = false;
        this.K = 2;
        this.y = new Path();
        this.z = new RectF();
        D(context);
        B(context);
    }

    public void setData(ItemData itemData, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, itemData, i2, str) == null) {
            setData(itemData, i2, str, true);
        }
    }

    public void setData(ItemData itemData, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{itemData, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || itemData == null) {
            return;
        }
        this.o = itemData.itemId;
        this.p = str;
        this.n = itemData.mTitle;
        this.q = itemData.mScore;
        this.r = itemData.mTags;
        ApkDetail apkDetail = itemData.apkDetail;
        if (apkDetail != null) {
            this.s = apkDetail.version;
            this.t = apkDetail.developer;
            this.u = apkDetail.privacy_url;
            this.v = apkDetail.authority_url;
        }
        this.f46115f.setText(z(this.n));
        this.f46114e.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        I();
        if (z) {
            G(itemData, str);
        }
        F(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i2, boolean z, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{itemData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.k.getStyleConfig();
        if (styleConfig instanceof b.a.q0.s.g0.n.c) {
            ((b.a.q0.s.g0.n.c) styleConfig).p(R.color.CAM_X0304);
        }
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.H = z;
        this.o = itemData.itemId;
        this.n = itemData.mTitle;
        this.q = itemData.mScore;
        this.r = itemData.mTags;
        ApkDetail apkDetail = itemData.apkDetail;
        if (apkDetail != null) {
            this.s = apkDetail.version;
            this.t = apkDetail.developer;
            this.u = apkDetail.privacy_url;
            this.v = apkDetail.authority_url;
        }
        this.j.setClickCallback(new c(this, i3, i4, itemData));
        this.j.setCustomColorBtn(SkinManager.getColor(R.color.CAM_X0303), false);
        this.j.setUserProgressTextGradientModel(true);
        b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.k.setConfig(bVar);
        this.f46115f.setText(z(this.n));
        this.f46114e.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        I();
        G(itemData, "");
        F(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i2, boolean z, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{itemData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.k.getStyleConfig();
        if (styleConfig instanceof b.a.q0.s.g0.n.c) {
            ((b.a.q0.s.g0.n.c) styleConfig).p(R.color.CAM_X0304);
        }
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.H = z;
        this.o = itemData.itemId;
        this.n = itemData.mTitle;
        this.q = itemData.mScore;
        this.r = itemData.mTags;
        ApkDetail apkDetail = itemData.apkDetail;
        if (apkDetail != null) {
            this.s = apkDetail.version;
            this.t = apkDetail.developer;
            this.u = apkDetail.privacy_url;
            this.v = apkDetail.authority_url;
        }
        b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.k.setConfig(bVar);
        this.l.setOnClickListener(new d(this, i4, i5, itemData));
        this.f46115f.setText(z(this.n));
        this.f46114e.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        I();
        J(itemData, i3);
        F(itemData.mIconSize);
    }
}
