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
import c.a.q0.d1.p0;
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
/* loaded from: classes6.dex */
public class ItemCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVALUATE_STYLE = 1;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int NORMA_STYLE = 0;
    public static final int O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static final int T;
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
    public String K;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f47680e;

    /* renamed from: f  reason: collision with root package name */
    public ItemEllipsisView f47681f;

    /* renamed from: g  reason: collision with root package name */
    public ItemEllipsisView f47682g;

    /* renamed from: h  reason: collision with root package name */
    public ItemEllipsisView f47683h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f47684i;

    /* renamed from: j  reason: collision with root package name */
    public ItemCardDownloadButton f47685j;
    public TBSpecificationBtn k;
    public ProgressButton l;
    public p0 m;
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

    /* loaded from: classes6.dex */
    public class a implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47688a;

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
            this.f47688a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.f47688a.f47685j.getObjTypeByDownloadMode();
                int a2 = c.a.q0.s.f0.p.c.a(this.f47688a.f47685j.getCurrentItem().buttonLinkType.intValue(), this.f47688a.f47685j.getCurrentItem().apkDetail != null ? this.f47688a.f47685j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a2 == 4) {
                    return;
                }
                ItemCardHelper.p(this.f47688a.I, this.f47688a.o, objTypeByDownloadMode, this.f47688a.p, a2, "");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47689a;

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
            this.f47689a = itemCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.f47689a.f47685j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode <= 0 || this.f47689a.H) {
                    return;
                }
                ItemCardHelper.p(this.f47689a.I, this.f47689a.o, objTypeByDownloadMode, this.f47689a.p, c.a.q0.s.f0.p.c.a(this.f47689a.f47685j.getCurrentItem().buttonLinkType.intValue(), this.f47689a.f47685j.getCurrentItem().apkDetail != null ? this.f47689a.f47685j.getCurrentItem().apkDetail.pkg_source.intValue() : 0), str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f47690a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f47691b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ItemData f47692c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47693d;

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
            this.f47693d = itemCardView;
            this.f47690a = i2;
            this.f47691b = i3;
            this.f47692c = itemData;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            int objTypeByDownloadMode;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (objTypeByDownloadMode = this.f47693d.f47685j.getObjTypeByDownloadMode()) <= 0) {
                return;
            }
            ItemCardHelper.f(this.f47690a, this.f47691b, objTypeByDownloadMode, 1, this.f47692c.mTitle);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47695f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ItemData f47696g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47697h;

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
            this.f47697h = itemCardView;
            this.f47694e = i2;
            this.f47695f = i3;
            this.f47696g = itemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                byte byteValue = ((Byte) this.f47697h.l.getTag()).byteValue();
                int i2 = 4;
                if (byteValue == 0) {
                    i2 = 2;
                } else if (byteValue == 1) {
                    i2 = 8;
                } else if (byteValue != 2) {
                    i2 = byteValue != 3 ? byteValue != 4 ? -1 : 5 : 7;
                }
                ItemCardHelper.f(this.f47694e, this.f47695f, i2, 2, this.f47696g.mTitle);
                this.f47697h.m.onClick(view);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47698a;

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
            this.f47698a = itemCardView;
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
                    return i2 > 1 && ((float) this.f47698a.n.length()) > (((float) layout.getLineEnd(0)) - this.f47698a.w) - 1.0f;
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
                TextPaint paint = this.f47698a.f47681f.getPaint();
                int measuredWidth = (int) (this.f47698a.f47681f.getMeasuredWidth() - this.f47698a.w);
                if (k.isEmpty(this.f47698a.n) || paint == null || measuredWidth <= 0) {
                    ItemCardView itemCardView = this.f47698a;
                    return itemCardView.x(itemCardView.n);
                }
                while (lineEnd > 0) {
                    if (this.f47698a.n.length() >= lineEnd) {
                        if (measuredWidth > paint.measureText(this.f47698a.n.substring(0, lineEnd - 1) + "...")) {
                            break;
                        }
                    }
                    lineEnd--;
                }
                if (lineEnd > 0) {
                    return this.f47698a.x(this.f47698a.n.substring(0, lineEnd - 1) + "...");
                }
                ItemCardView itemCardView2 = this.f47698a;
                return itemCardView2.x(itemCardView2.n);
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47699a;

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
            this.f47699a = itemCardView;
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
                int measuredWidth = this.f47699a.f47682g.getWidth() == 0 ? this.f47699a.f47682g.getMeasuredWidth() : this.f47699a.f47682g.getWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = Integer.MAX_VALUE;
                }
                TextPaint paint = this.f47699a.f47682g.getPaint();
                if (paint == null) {
                    return spannableStringBuilder;
                }
                if (!k.isEmpty(this.f47699a.s)) {
                    measuredWidth -= (int) (ItemCardView.S + paint.measureText(((Object) this.f47699a.getContext().getText(R.string.item_version)) + this.f47699a.s));
                }
                if (ListUtils.getCount(this.f47699a.r) > 0) {
                    for (int i2 = 0; i2 < this.f47699a.r.size(); i2++) {
                        if (!k.isEmpty((String) this.f47699a.r.get(i2))) {
                            float measureText = measuredWidth - paint.measureText(((String) this.f47699a.r.get(i2)) + " ");
                            if (measureText <= 0.0f) {
                                break;
                            }
                            spannableStringBuilder.append((CharSequence) this.f47699a.r.get(i2));
                            spannableStringBuilder.append((CharSequence) " ");
                            measuredWidth = (int) measureText;
                        }
                    }
                }
                if (!k.isEmpty(this.f47699a.s)) {
                    if (spannableStringBuilder.length() > 1) {
                        spannableStringBuilder.setSpan(new c.a.q0.s.f0.r.b(ItemCardView.S), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    }
                    spannableStringBuilder.append(this.f47699a.getContext().getText(R.string.item_version));
                    spannableStringBuilder.append((CharSequence) this.f47699a.s);
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47700a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f47701b;

        /* loaded from: classes6.dex */
        public class a extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f47702e;

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
                this.f47702e = gVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f47702e.f47701b.u) && (j.a(this.f47702e.f47701b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f47702e.f47701b.getContext()), new String[]{this.f47702e.f47701b.u});
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
            public final /* synthetic */ g f47703e;

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
                this.f47703e = gVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !k.isEmpty(this.f47703e.f47701b.v) && (j.a(this.f47703e.f47701b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f47703e.f47701b.getContext()), new String[]{this.f47703e.f47701b.v});
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
            this.f47701b = itemCardView;
            this.f47700a = 1;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47700a : invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean b(int i2, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, layout)) == null) {
                if (layout != null) {
                    if (i2 == 2 && this.f47701b.t != null && this.f47701b.t.endsWith(this.f47701b.K)) {
                        return true;
                    }
                    if (i2 > 0) {
                        int i3 = i2 - 1;
                        return layout.getLineEnd(i3) - layout.getLineStart(i3) < this.f47701b.x;
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
                if (!k.isEmpty(this.f47701b.u) || !k.isEmpty(this.f47701b.v)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " |");
                    int i2 = length + 1;
                    spannableStringBuilder.setSpan(new c.a.q0.s.f0.r.b(ItemCardView.T), length, i2, 33);
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X10), new ColorStateList(new int[][]{new int[0]}, new int[]{c.a.r0.k3.c.a(SkinManager.getColor(R.color.CAM_X0108), c.a.q0.s.u.a.a(R.string.A_X10))}), null), i2, length + 2, 33);
                    if (!k.isEmpty(this.f47701b.u)) {
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f47701b.getContext().getString(R.string.item_download_privacy));
                        int i3 = length2 + 1;
                        spannableStringBuilder.setSpan(new c.a.q0.s.f0.r.b(ItemCardView.T), length2, i3, 33);
                        spannableStringBuilder.setSpan(new a(this), i3, length2 + 3, 33);
                    }
                    if (!k.isEmpty(this.f47701b.v)) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f47701b.getContext().getString(R.string.item_download_authority));
                        int i4 = length3 + 1;
                        spannableStringBuilder.setSpan(new c.a.q0.s.f0.r.b(ItemCardView.T), length3, i4, 33);
                        spannableStringBuilder.setSpan(new b(this), i4, length3 + 3, 33);
                    }
                }
                if (layout == null) {
                    spannableStringBuilder.insert(0, (CharSequence) this.f47701b.t);
                    return spannableStringBuilder;
                }
                TextPaint paint = this.f47701b.f47683h.getPaint();
                if (this.f47701b.t != null && paint != null) {
                    this.f47701b.x = spannableStringBuilder.length();
                    float measureText = paint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
                    int measuredWidth = this.f47701b.f47683h.getMeasuredWidth();
                    int lineCount = layout.getLineCount();
                    this.f47700a = lineCount;
                    if (lineCount == 2 && this.f47701b.t != null && this.f47701b.t.endsWith(this.f47701b.K) && paint.measureText(this.f47701b.t.substring(0, this.f47701b.t.length() - 4)) + measureText <= measuredWidth) {
                        this.f47700a = 1;
                        spannableStringBuilder.insert(0, (CharSequence) this.f47701b.t.substring(0, this.f47701b.t.length() - 4));
                        return spannableStringBuilder;
                    }
                    int i5 = this.f47700a;
                    if (i5 > 0) {
                        int lineEnd = layout.getLineEnd(i5 - 1) - layout.getLineStart(this.f47700a - 1);
                        spannableStringBuilder.insert(0, (CharSequence) this.f47701b.t);
                        if (lineEnd < this.f47701b.x) {
                            spannableStringBuilder.insert(this.f47701b.t.length(), (CharSequence) StringUtils.LF);
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
        L = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        M = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        N = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        O = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        P = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        Q = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        R = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        S = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004);
        T = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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
            if ((list == null || list.isEmpty() || !B(list)) && k.isEmpty(this.s)) {
                this.f47682g.setVisibility(8);
                return;
            }
            this.f47682g.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f47682g;
            itemEllipsisView.setText(itemEllipsisView.iGetTextSpanCallback.c(null));
        }
    }

    public final void A(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.K = context.getString(R.string.limited_company);
            LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
            this.f47680e = (TbImageView) findViewById(R.id.item_image);
            this.f47681f = (ItemEllipsisView) findViewById(R.id.first_info);
            this.f47682g = (ItemEllipsisView) findViewById(R.id.second_info);
            ItemEllipsisView itemEllipsisView = (ItemEllipsisView) findViewById(R.id.third_info);
            this.f47683h = itemEllipsisView;
            itemEllipsisView.setMovementMethod(ItemEllipsisView.a.a());
            this.f47684i = (ImageView) findViewById(R.id.bt_del);
            ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) findViewById(R.id.order_download_btn);
            this.f47685j = itemCardDownloadButton;
            itemCardDownloadButton.setClickCallback(new a(this));
            this.k = (TBSpecificationBtn) findViewById(R.id.order_or_download);
            c.a.q0.s.f0.n.c cVar = new c.a.q0.s.f0.n.c();
            cVar.p(R.color.CAM_X0304);
            this.k.setConfig(cVar);
            this.f47680e.setDrawCorner(true);
            this.f47680e.setConrers(15);
            this.f47680e.setRadiusById(this.D);
            this.f47680e.setPlaceHolder(1);
            this.f47680e.setDrawBorder(true);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tie_plus_download_btn);
            this.l = progressButton;
            progressButton.setUseLongText(false);
            this.l.setVisibility(8);
            p0 p0Var = new p0(getContext());
            this.m = p0Var;
            p0Var.d(this.l);
            onChangeSkinType();
            z();
        }
    }

    public final boolean B(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void C(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f47680e.getLayoutParams();
            if (d2 == 1.0d) {
                layoutParams.width = L;
                layoutParams.height = M;
            } else if (d2 < 1.0d) {
                layoutParams.width = N;
                layoutParams.height = O;
            } else {
                layoutParams.width = P;
                layoutParams.height = Q;
            }
            this.f47680e.setLayoutParams(layoutParams);
        }
    }

    public final void D(ItemData itemData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, itemData, str) == null) || itemData == null) {
            return;
        }
        this.l.setVisibility(8);
        if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
            this.F = true;
            this.f47685j.setData(itemData, this.I, str);
            this.f47685j.setVisibility(0);
            int objTypeByDownloadMode = this.f47685j.getObjTypeByDownloadMode();
            if (objTypeByDownloadMode > 0 && !this.H) {
                ItemCardHelper.r(this.I, itemData.itemId, objTypeByDownloadMode, str);
            }
        } else {
            this.F = false;
            this.f47685j.setVisibility(8);
            if (this.E) {
                c.a.q0.s.f0.p.a aVar = new c.a.q0.s.f0.p.a(itemData, this.I, str);
                boolean equals = ItemCardHelper.f47983f.equals(itemData.buttonName);
                ItemCardHelper.n(this.k, aVar);
                ItemData a2 = aVar.a();
                this.k.setText(a2.buttonName);
                this.k.changeSkinType();
                int e2 = ItemCardHelper.e(a2.buttonName);
                if (-1 != e2 && !this.H) {
                    int i2 = this.I;
                    long j2 = a2.itemId;
                    if (equals) {
                        e2 = 9;
                    }
                    ItemCardHelper.r(i2, j2, e2, str);
                }
            }
        }
        setIsShowRightBtn(this.E);
    }

    public final void E(Item item, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, item, str) == null) || item == null) {
            return;
        }
        ItemData itemData = new ItemData();
        itemData.parseProto(item);
        D(itemData, str);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (k.isEmpty(this.t) && k.isEmpty(this.u) && k.isEmpty(this.v)) {
                this.f47683h.setVisibility(8);
                return;
            }
            this.f47683h.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f47683h;
            itemEllipsisView.setText(itemEllipsisView.iGetTextSpanCallback.c(null));
        }
    }

    public final void G(ItemData itemData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, itemData, i2) == null) || itemData == null) {
            return;
        }
        if ((ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) || i2 == 1) {
            this.l.setVisibility(0);
            this.k.setVisibility(8);
            this.f47685j.setVisibility(8);
            p0 p0Var = this.m;
            p0Var.r(itemData.appId);
            p0Var.t(itemData.buttonLink);
            p0Var.v(itemData.pkgName);
            p0 p0Var2 = this.m;
            p0Var2.D(p0Var2.i(), this.m.h(), getContext(), this.l);
            this.m.u(itemData);
            return;
        }
        this.F = false;
        this.f47685j.setVisibility(8);
        this.l.setVisibility(8);
        if (this.E) {
            c.a.q0.s.f0.p.a aVar = new c.a.q0.s.f0.p.a(itemData, this.I, "");
            ItemCardHelper.n(this.k, aVar);
            this.k.setText(aVar.a().buttonName);
            this.k.changeSkinType();
        }
        setIsShowRightBtn(this.E);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
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

    public int getButtonType() {
        InterceptResult invokeV;
        ItemCardDownloadButton itemCardDownloadButton;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.E && (tBSpecificationBtn = this.k) != null) {
                return ItemCardHelper.e(tBSpecificationBtn.getText());
            }
            if (!this.F || (itemCardDownloadButton = this.f47685j) == null) {
                return -1;
            }
            return itemCardDownloadButton.getObjTypeByDownloadMode();
        }
        return invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.I : invokeV.intValue;
    }

    public void hideCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f47684i.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SkinManager.setBackgroundColor(this, this.A);
            c.a.q0.s.u.c.d(this.f47681f).v(this.C);
            c.a.q0.s.u.c.d(this.f47682g).v(R.color.CAM_X0109);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f47683h);
            d2.w(R.dimen.M_T_X001);
            d2.v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47684i, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f47680e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.f47680e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f47680e.setPlaceHolder(1);
            this.k.changeSkinType();
            this.f47685j.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = "";
            this.A = R.color.CAM_X0206;
            this.B = R;
            this.C = R.color.CAM_X0107;
            this.D = R.string.J_X04;
            this.E = false;
            this.F = false;
            this.H = false;
            c.a.q0.s.f0.n.c cVar = new c.a.q0.s.f0.n.c();
            cVar.p(R.color.CAM_X0304);
            this.k.setConfig(cVar);
            this.f47680e.setDrawCorner(true);
            this.f47680e.setConrers(15);
            this.f47680e.setRadiusById(this.D);
            this.f47680e.setPlaceHolder(1);
            this.f47680e.setDrawBorder(true);
            this.l.setUseLongText(false);
            this.l.setVisibility(8);
        }
    }

    public void setBackGroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.A = i2;
            onChangeSkinType();
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048596, this, tbRichTextEvaluateItemInfo, i2, str) == null) || tbRichTextEvaluateItemInfo == null) {
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
        this.f47681f.setText(x(this.n));
        this.f47680e.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i2, false);
        setTag(tbRichTextEvaluateItemInfo.getTags());
        F();
        E(tbRichTextEvaluateItemInfo.getItem(), str);
        C(tbRichTextEvaluateItemInfo.getIconSize());
    }

    public void setFirstLineTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.C = i2;
            onChangeSkinType();
        }
    }

    public void setHighLightText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.J = str;
        }
    }

    public void setIsShowRightBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.D = i2;
            TbImageView tbImageView = this.f47680e;
            if (tbImageView != null) {
                tbImageView.setRadiusById(i2);
            }
        }
    }

    public void setOnClickListenerOfRightBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            this.f47684i.setOnClickListener(onClickListener);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.I = i2;
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.B = i2;
            postInvalidate();
        }
    }

    public void setSizeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
        }
    }

    public void showCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f47684i.setVisibility(0);
        }
    }

    public final SpannableStringBuilder x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(k.isEmpty(str) ? "" : str);
            this.w = 0.0f;
            if (!TextUtils.isEmpty(this.J)) {
                UtilHelper.setSpan(spannableStringBuilder, str, this.J, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            }
            double d2 = this.q;
            if (d2 > 0.0d && d2 <= 10.0d) {
                int length = spannableStringBuilder.length();
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_star_16, R.color.CAM_X0305, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
                eMRichTextAnyIconSpan.d(UtilHelper.getDimenPixelSize(R.dimen.tbds7));
                eMRichTextAnyIconSpan.e(UtilHelper.getDimenPixelSize(R.dimen.tbds6));
                eMRichTextAnyIconSpan.f(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                String str2 = this.q + "";
                TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X09), SkinManager.getColorList(R.color.CAM_X0305), null);
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(textAppearanceSpan, spannableStringBuilder.length() - str2.length(), spannableStringBuilder.length(), 33);
                this.w = this.f47681f.getPaint().measureText(spannableStringBuilder, length == 0 ? 0 : length - 1, spannableStringBuilder.length());
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
            b bVar = new b(this, 2921609);
            this.G = bVar;
            bVar.setTag(this.f47685j.getTag());
            this.G.setSelfListener(true);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f47681f.iGetTextSpanCallback = new e(this);
            this.f47682g.iGetTextSpanCallback = new f(this);
            this.f47683h.iGetTextSpanCallback = new g(this);
        }
    }

    /* loaded from: classes6.dex */
    public static class ItemEllipsisView extends EMTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public boolean f47686f;
        public b iGetTextSpanCallback;

        /* loaded from: classes6.dex */
        public static class a extends LinkMovementMethod {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f47687a;
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
                    if (f47687a == null) {
                        f47687a = new a();
                    }
                    return f47687a;
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
                            ((ItemEllipsisView) textView).f47686f = true;
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
            this.f47686f = false;
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
                this.f47686f = false;
                super.onTouchEvent(motionEvent);
                return this.f47686f;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f47686f) {
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
            this.f47686f = false;
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
            this.f47686f = false;
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
        this.A = R.color.CAM_X0206;
        this.B = R;
        this.C = R.color.CAM_X0107;
        this.D = R.string.J_X04;
        this.E = false;
        this.F = false;
        this.H = false;
        this.y = new Path();
        this.z = new RectF();
        A(context);
        y(context);
    }

    public void setData(ItemData itemData, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, itemData, i2, str) == null) {
            setData(itemData, i2, str, true);
        }
    }

    public void setData(ItemData itemData, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{itemData, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || itemData == null) {
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
        this.f47681f.setText(x(this.n));
        this.f47680e.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        F();
        if (z) {
            D(itemData, str);
        }
        C(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i2, boolean z, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{itemData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.k.getStyleConfig();
        if (styleConfig instanceof c.a.q0.s.f0.n.c) {
            ((c.a.q0.s.f0.n.c) styleConfig).p(R.color.CAM_X0304);
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
        this.f47685j.setClickCallback(new c(this, i3, i4, itemData));
        this.f47685j.setCustomColorBtn(SkinManager.getColor(R.color.CAM_X0303), false);
        this.f47685j.setUserProgressTextGradientModel(true);
        c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.k.setConfig(bVar);
        this.f47681f.setText(x(this.n));
        this.f47680e.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        F();
        D(itemData, "");
        C(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i2, boolean z, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{itemData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.k.getStyleConfig();
        if (styleConfig instanceof c.a.q0.s.f0.n.c) {
            ((c.a.q0.s.f0.n.c) styleConfig).p(R.color.CAM_X0304);
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
        c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.k.setConfig(bVar);
        this.l.setOnClickListener(new d(this, i4, i5, itemData));
        this.f47681f.setText(x(this.n));
        this.f47680e.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        F();
        G(itemData, i3);
        C(itemData.mIconSize);
    }
}
