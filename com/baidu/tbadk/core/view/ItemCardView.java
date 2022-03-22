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
import c.a.d.a.j;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
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
import com.baidu.tbadk.core.util.StringHelper;
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
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes5.dex */
public class ItemCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int I;
    public static final int J;
    public static final int K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int O;
    public static final int P;
    public static final int Q;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public CustomMessageListener C;
    public boolean D;
    public int E;
    public String F;
    public int G;
    public String H;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ItemEllipsisView f30003b;

    /* renamed from: c  reason: collision with root package name */
    public ItemEllipsisView f30004c;

    /* renamed from: d  reason: collision with root package name */
    public ItemEllipsisView f30005d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30006e;

    /* renamed from: f  reason: collision with root package name */
    public ItemCardDownloadButton f30007f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f30008g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressButton f30009h;
    public TiePlusHelper i;
    public String j;
    public long k;
    public String l;
    public double m;
    public List<String> n;
    public String o;
    public String p;
    public String q;
    public String r;
    public float s;
    public int t;
    public Path u;
    public RectF v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardView a;

        public a(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int objTypeByDownloadMode = this.a.f30007f.getObjTypeByDownloadMode();
                int a = c.a.o0.r.l0.p.c.a(this.a.f30007f.getCurrentItem().buttonLinkType.intValue(), this.a.f30007f.getCurrentItem().apkDetail != null ? this.a.f30007f.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a == 4) {
                    return;
                }
                ItemCardHelper.p(this.a.E, this.a.k, objTypeByDownloadMode, this.a.l, a, "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ItemCardView itemCardView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.a.f30007f.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode <= 0 || this.a.D) {
                    return;
                }
                ItemCardHelper.p(this.a.E, this.a.k, objTypeByDownloadMode, this.a.l, c.a.o0.r.l0.p.c.a(this.a.f30007f.getCurrentItem().buttonLinkType.intValue(), this.a.f30007f.getCurrentItem().apkDetail != null ? this.a.f30007f.getCurrentItem().apkDetail.pkg_source.intValue() : 0), str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f30013b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ItemData f30014c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f30015d;

        public c(ItemCardView itemCardView, int i, int i2, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView, Integer.valueOf(i), Integer.valueOf(i2), itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30015d = itemCardView;
            this.a = i;
            this.f30013b = i2;
            this.f30014c = itemData;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i) {
            int objTypeByDownloadMode;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (objTypeByDownloadMode = this.f30015d.f30007f.getObjTypeByDownloadMode()) <= 0) {
                return;
            }
            ItemCardHelper.f(this.a, this.f30013b, objTypeByDownloadMode, 1, this.f30014c.mTitle, true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f30016b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ItemData f30017c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f30018d;

        public d(ItemCardView itemCardView, int i, int i2, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView, Integer.valueOf(i), Integer.valueOf(i2), itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30018d = itemCardView;
            this.a = i;
            this.f30016b = i2;
            this.f30017c = itemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.f(this.a, this.f30016b, this.f30018d.getTiePlusButtonState(), 2, this.f30017c.mTitle, true);
                this.f30018d.i.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardView a;

        public e(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardView;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.G : invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                if (z) {
                    ItemCardView itemCardView = this.a;
                    return itemCardView.A(itemCardView.j);
                }
                int lineStart = layout.getLineStart(this.a.G - 1);
                int lineEnd = layout.getLineEnd(this.a.G - 1);
                TextPaint paint = this.a.f30003b.getPaint();
                int measuredWidth = (int) (this.a.f30003b.getMeasuredWidth() - this.a.s);
                if (m.isEmpty(this.a.j) || paint == null || measuredWidth <= 0) {
                    ItemCardView itemCardView2 = this.a;
                    return itemCardView2.A(itemCardView2.j);
                }
                while (lineEnd > 0) {
                    if (this.a.j.length() >= lineEnd) {
                        if (measuredWidth > paint.measureText(this.a.j.substring(lineStart, lineEnd - 1) + StringHelper.STRING_MORE)) {
                            break;
                        }
                    }
                    lineEnd--;
                }
                if (lineEnd > 0) {
                    return this.a.A(this.a.j.substring(0, lineEnd - 1) + StringHelper.STRING_MORE);
                }
                ItemCardView itemCardView3 = this.a;
                return itemCardView3.A(itemCardView3.j);
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean c(int i, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, layout)) == null) ? layout != null && i > this.a.G : invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder d(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layout)) == null) {
                int lineCount = layout.getLineCount();
                if (lineCount != 0 && lineCount != 1) {
                    TextPaint paint = this.a.f30003b.getPaint();
                    int measuredWidth = this.a.f30003b.getWidth() == 0 ? this.a.f30003b.getMeasuredWidth() : this.a.f30003b.getWidth();
                    float measureText = paint.measureText(this.a.j.substring(layout.getLineStart(lineCount - 2)));
                    float f2 = measuredWidth;
                    if (measureText <= f2 && measureText > f2 - this.a.s) {
                        ItemCardView itemCardView = this.a;
                        return itemCardView.B(itemCardView.j, true);
                    }
                }
                return null;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardView a;

        public f(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardView;
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
                int measuredWidth = this.a.f30004c.getWidth() == 0 ? this.a.f30004c.getMeasuredWidth() : this.a.f30004c.getWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = Integer.MAX_VALUE;
                }
                TextPaint paint = this.a.f30004c.getPaint();
                if (paint == null) {
                    return spannableStringBuilder;
                }
                if (!m.isEmpty(this.a.o)) {
                    measuredWidth -= (int) (ItemCardView.P + paint.measureText(((Object) this.a.getContext().getText(R.string.obfuscated_res_0x7f0f097b)) + this.a.o));
                }
                if (ListUtils.getCount(this.a.n) > 0) {
                    for (int i = 0; i < this.a.n.size(); i++) {
                        if (!m.isEmpty((String) this.a.n.get(i))) {
                            float measureText = measuredWidth - paint.measureText(((String) this.a.n.get(i)) + " ");
                            if (measureText <= 0.0f) {
                                break;
                            }
                            spannableStringBuilder.append((CharSequence) this.a.n.get(i));
                            spannableStringBuilder.append((CharSequence) " ");
                            measuredWidth = (int) measureText;
                        }
                    }
                }
                if (!m.isEmpty(this.a.o)) {
                    if (spannableStringBuilder.length() > 1) {
                        spannableStringBuilder.setSpan(new c.a.o0.r.l0.r.b(ItemCardView.P), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    }
                    spannableStringBuilder.append(this.a.getContext().getText(R.string.obfuscated_res_0x7f0f097b));
                    spannableStringBuilder.append((CharSequence) this.a.o);
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean c(int i, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, layout)) == null) ? i > 1 : invokeIL.booleanValue;
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

    /* loaded from: classes5.dex */
    public class g implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f30019b;

        /* loaded from: classes5.dex */
        public class a extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !m.isEmpty(this.a.f30019b.q) && (j.a(this.a.f30019b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.f30019b.getContext()), new String[]{this.a.f30019b.q});
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

        /* loaded from: classes5.dex */
        public class b extends ClickableSpan {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !m.isEmpty(this.a.f30019b.r) && (j.a(this.a.f30019b.getContext()) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.f30019b.getContext()), new String[]{this.a.f30019b.r});
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30019b = itemCardView;
            this.a = 1;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!m.isEmpty(this.f30019b.q) || !m.isEmpty(this.f30019b.r)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " |");
                    int i = length + 1;
                    spannableStringBuilder.setSpan(new c.a.o0.r.l0.r.b(ItemCardView.Q), length, i, 33);
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X10), new ColorStateList(new int[][]{new int[0]}, new int[]{c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0108), c.a.o0.r.v.a.a(R.string.A_X10))}), null), i, length + 2, 33);
                    if (!m.isEmpty(this.f30019b.q)) {
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f30019b.getContext().getString(R.string.obfuscated_res_0x7f0f096e));
                        int i2 = length2 + 1;
                        spannableStringBuilder.setSpan(new c.a.o0.r.l0.r.b(ItemCardView.Q), length2, i2, 33);
                        spannableStringBuilder.setSpan(new a(this), i2, length2 + 3, 33);
                    }
                    if (!m.isEmpty(this.f30019b.r)) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.f30019b.getContext().getString(R.string.obfuscated_res_0x7f0f0968));
                        int i3 = length3 + 1;
                        spannableStringBuilder.setSpan(new c.a.o0.r.l0.r.b(ItemCardView.Q), length3, i3, 33);
                        spannableStringBuilder.setSpan(new b(this), i3, length3 + 3, 33);
                    }
                }
                if (layout == null) {
                    spannableStringBuilder.insert(0, (CharSequence) this.f30019b.p);
                    return spannableStringBuilder;
                }
                TextPaint paint = this.f30019b.f30005d.getPaint();
                if (this.f30019b.p != null && paint != null) {
                    this.f30019b.t = spannableStringBuilder.length();
                    float measureText = paint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
                    int measuredWidth = this.f30019b.f30005d.getMeasuredWidth();
                    int lineCount = layout.getLineCount();
                    this.a = lineCount;
                    if (lineCount == 2 && this.f30019b.p != null && this.f30019b.p.endsWith(this.f30019b.H) && paint.measureText(this.f30019b.p.substring(0, this.f30019b.p.length() - 4)) + measureText <= measuredWidth) {
                        this.a = 1;
                        spannableStringBuilder.insert(0, (CharSequence) this.f30019b.p.substring(0, this.f30019b.p.length() - 4));
                        return spannableStringBuilder;
                    }
                    int i4 = this.a;
                    if (i4 > 0) {
                        int lineEnd = layout.getLineEnd(i4 - 1) - layout.getLineStart(this.a - 1);
                        spannableStringBuilder.insert(0, (CharSequence) this.f30019b.p);
                        if (lineEnd < this.f30019b.t) {
                            spannableStringBuilder.insert(this.f30019b.p.length(), (CharSequence) "\n");
                        }
                    }
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean c(int i, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, layout)) == null) {
                if (layout != null) {
                    if (i == 2 && this.f30019b.p != null && this.f30019b.p.endsWith(this.f30019b.H)) {
                        return true;
                    }
                    if (i > 0) {
                        int i2 = i - 1;
                        return layout.getLineEnd(i2) - layout.getLineStart(i2) < this.f30019b.t;
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
        I = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        J = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        K = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        L = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        M = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        N = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        O = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        P = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004);
        Q = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            ProgressButton progressButton = this.f30009h;
            if (progressButton == null || progressButton.getVisibility() != 0) {
                return -1;
            }
            byte byteValue = ((Byte) this.f30009h.getTag()).byteValue();
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
            if (ItemCardHelper.f30252b.equals(str)) {
                this.G = 1;
            } else {
                this.G = 2;
            }
            this.f30003b.f30012d = this.G;
        }
    }

    private void setTag(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, list) == null) {
            if ((list == null || list.isEmpty() || !F(list)) && m.isEmpty(this.o)) {
                this.f30004c.setVisibility(8);
                return;
            }
            this.f30004c.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f30004c;
            itemEllipsisView.setText(itemEllipsisView.f30010b.b(null, false));
        }
    }

    public final SpannableStringBuilder A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? B(str, false) : (SpannableStringBuilder) invokeL.objValue;
    }

    public final SpannableStringBuilder B(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m.isEmpty(str) ? "" : str);
            this.s = 0.0f;
            if (!TextUtils.isEmpty(this.F)) {
                UtilHelper.setSpan(spannableStringBuilder, str, this.F, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            }
            double d2 = this.m;
            if (d2 > 0.0d && d2 <= 10.0d) {
                int length = spannableStringBuilder.length();
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080994, R.color.CAM_X0305, EMRichTextAnyIconSpan.IconType.WEBP);
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
                String str2 = this.m + "";
                TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X09), SkinManager.getColorList(R.color.CAM_X0305), null);
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(textAppearanceSpan, spannableStringBuilder.length() - str2.length(), spannableStringBuilder.length(), 33);
                this.s = this.f30003b.getPaint().measureText(spannableStringBuilder, length == 0 ? 0 : length - 1, spannableStringBuilder.length());
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            b bVar = new b(this, 2921609);
            this.C = bVar;
            bVar.setTag(this.f30007f.getTag());
            this.C.setSelfListener(true);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f30003b.f30010b = new e(this);
            ItemEllipsisView itemEllipsisView = this.f30003b;
            itemEllipsisView.f30012d = itemEllipsisView.f30010b.a();
            this.f30004c.f30010b = new f(this);
            this.f30005d.f30010b = new g(this);
        }
    }

    public final void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.H = context.getString(R.string.obfuscated_res_0x7f0f09e3);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d03fa, (ViewGroup) this, true);
            this.a = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090f7c);
            this.f30003b = (ItemEllipsisView) findViewById(R.id.obfuscated_res_0x7f0909a0);
            this.f30004c = (ItemEllipsisView) findViewById(R.id.obfuscated_res_0x7f091c57);
            ItemEllipsisView itemEllipsisView = (ItemEllipsisView) findViewById(R.id.obfuscated_res_0x7f091f81);
            this.f30005d = itemEllipsisView;
            itemEllipsisView.setMovementMethod(ItemEllipsisView.a.a());
            this.f30006e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0903f2);
            ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) findViewById(R.id.obfuscated_res_0x7f091615);
            this.f30007f = itemCardDownloadButton;
            itemCardDownloadButton.setClickCallback(new a(this));
            this.f30008g = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f091618);
            c.a.o0.r.l0.n.c cVar = new c.a.o0.r.l0.n.c();
            cVar.p(R.color.CAM_X0304);
            this.f30008g.setConfig(cVar);
            this.a.setDrawCorner(true);
            this.a.setConrers(15);
            this.a.setRadiusById(this.z);
            this.a.setPlaceHolder(1);
            this.a.setDrawBorder(true);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f091fe8);
            this.f30009h = progressButton;
            progressButton.setUseLongText(false);
            this.f30009h.setVisibility(8);
            TiePlusHelper tiePlusHelper = new TiePlusHelper(getContext());
            this.i = tiePlusHelper;
            tiePlusHelper.f(this.f30009h);
            G();
            D();
        }
    }

    public final boolean F(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this, this.w);
            c.a.o0.r.v.c.d(this.f30003b).v(this.y);
            c.a.o0.r.v.c.d(this.f30004c).v(R.color.CAM_X0109);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f30005d);
            d2.w(R.dimen.M_T_X001);
            d2.v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f30006e, R.drawable.obfuscated_res_0x7f08097f, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.a.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a.setPlaceHolder(1);
            this.f30008g.k();
            this.f30007f.v();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o = "";
            this.p = "";
            this.q = "";
            this.r = "";
            this.w = R.color.CAM_X0206;
            this.x = O;
            this.y = R.color.CAM_X0107;
            this.z = R.string.J_X04;
            this.A = false;
            this.B = false;
            this.D = false;
            this.G = 2;
            c.a.o0.r.l0.n.c cVar = new c.a.o0.r.l0.n.c();
            cVar.p(R.color.CAM_X0304);
            this.f30008g.setConfig(cVar);
            this.a.setDrawCorner(true);
            this.a.setConrers(15);
            this.a.setRadiusById(this.z);
            this.a.setPlaceHolder(1);
            this.a.setDrawBorder(true);
            this.f30009h.setUseLongText(false);
            this.f30009h.setVisibility(8);
        }
    }

    public final void I(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            if (d2 == 1.0d || d2 <= 0.0d) {
                layoutParams.width = I;
                layoutParams.height = J;
            } else if (d2 < 1.0d) {
                layoutParams.width = K;
                layoutParams.height = L;
            } else {
                layoutParams.width = M;
                layoutParams.height = N;
            }
            this.a.setLayoutParams(layoutParams);
        }
    }

    public final void J(ItemData itemData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, itemData, str) == null) || itemData == null) {
            return;
        }
        this.f30009h.setVisibility(8);
        if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
            this.B = true;
            this.f30007f.setData(itemData, this.E, str);
            this.f30007f.setVisibility(0);
            int objTypeByDownloadMode = this.f30007f.getObjTypeByDownloadMode();
            if (objTypeByDownloadMode > 0 && !this.D) {
                ItemCardHelper.r(this.E, itemData.itemId, objTypeByDownloadMode, str);
            }
        } else {
            this.B = false;
            this.f30007f.setVisibility(8);
            if (this.A) {
                c.a.o0.r.l0.p.a aVar = new c.a.o0.r.l0.p.a(itemData, this.E, str);
                boolean equals = ItemCardHelper.f30256f.equals(itemData.buttonName);
                ItemCardHelper.n(this.f30008g, aVar);
                ItemData a2 = aVar.a();
                this.f30008g.setText(a2.buttonName);
                this.f30008g.k();
                int e2 = ItemCardHelper.e(a2.buttonName);
                if (-1 != e2 && !this.D) {
                    int i = this.E;
                    long j = a2.itemId;
                    if (equals) {
                        e2 = 9;
                    }
                    ItemCardHelper.r(i, j, e2, str);
                }
                itemData = a2;
            }
        }
        setMaxLinesByItemButtonName(itemData.buttonName);
        setIsShowRightBtn(this.A);
    }

    public final void K(Item item, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, item, str) == null) || item == null) {
            return;
        }
        ItemData itemData = new ItemData();
        itemData.parseProto(item);
        J(itemData, str);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (m.isEmpty(this.p) && m.isEmpty(this.q) && m.isEmpty(this.r)) {
                this.f30005d.setVisibility(8);
                return;
            }
            this.f30005d.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.f30005d;
            itemEllipsisView.setText(itemEllipsisView.f30010b.b(null, false));
        }
    }

    public final void M(ItemData itemData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, itemData, i) == null) || itemData == null) {
            return;
        }
        if ((ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) || i == 1) {
            this.f30009h.setVisibility(0);
            this.f30008g.setVisibility(8);
            this.f30007f.setVisibility(8);
            TiePlusHelper tiePlusHelper = this.i;
            tiePlusHelper.E(itemData.appId);
            tiePlusHelper.J(itemData.buttonLink);
            tiePlusHelper.M(itemData.pkgName);
            TiePlusHelper tiePlusHelper2 = this.i;
            tiePlusHelper2.Y(tiePlusHelper2.p(), this.i.m(), getContext(), this.f30009h);
            this.i.L(itemData);
        } else {
            this.B = false;
            this.f30007f.setVisibility(8);
            this.f30009h.setVisibility(8);
            if (this.A) {
                c.a.o0.r.l0.p.a aVar = new c.a.o0.r.l0.p.a(itemData, this.E, "");
                ItemCardHelper.n(this.f30008g, aVar);
                itemData = aVar.a();
                this.f30008g.setText(itemData.buttonName);
                this.f30008g.k();
            }
            setIsShowRightBtn(this.A);
        }
        setMaxLinesByItemButtonName(itemData.buttonName);
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f30006e.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.u.reset();
            this.v.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            Path path = this.u;
            RectF rectF = this.v;
            int i = this.x;
            path.addRoundRect(rectF, i, i, Path.Direction.CW);
            canvas.clipPath(this.u);
            super.draw(canvas);
        }
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.E : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.C);
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.C);
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void setBackGroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.w = i;
            G();
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048599, this, tbRichTextEvaluateItemInfo, i, str) == null) || tbRichTextEvaluateItemInfo == null) {
            return;
        }
        this.l = str;
        this.j = tbRichTextEvaluateItemInfo.getTitle();
        this.m = tbRichTextEvaluateItemInfo.getScore();
        this.n = tbRichTextEvaluateItemInfo.getTags();
        if (tbRichTextEvaluateItemInfo.getItem() != null) {
            this.k = tbRichTextEvaluateItemInfo.getItem().item_id.longValue();
            if (tbRichTextEvaluateItemInfo.getItem().apk_detail != null) {
                this.o = tbRichTextEvaluateItemInfo.getItem().apk_detail.version;
                this.p = tbRichTextEvaluateItemInfo.getItem().apk_detail.developer;
                this.q = tbRichTextEvaluateItemInfo.getItem().apk_detail.privacy_url;
                this.r = tbRichTextEvaluateItemInfo.getItem().apk_detail.authority_url;
            }
        }
        this.f30003b.setText(A(this.j));
        this.a.J(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        setTag(tbRichTextEvaluateItemInfo.getTags());
        L();
        K(tbRichTextEvaluateItemInfo.getItem(), str);
        I(tbRichTextEvaluateItemInfo.getIconSize());
    }

    public void setFirstLineTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.y = i;
            G();
        }
    }

    public void setHighLightText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.F = str;
        }
    }

    public void setIsShowRightBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.A = z;
            if (z && !this.B) {
                this.f30008g.setVisibility(0);
            } else {
                this.f30008g.setVisibility(8);
            }
        }
    }

    public void setItemImageViewRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.z = i;
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setRadiusById(i);
            }
        }
    }

    public void setOnClickListenerOfRightBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.f30008g.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.f30006e.setOnClickListener(onClickListener);
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.E = i;
        }
    }

    public void setRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.x = i;
            postInvalidate();
        }
    }

    public void setSizeStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
        }
    }

    public int z(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, itemData)) == null) {
            if (itemData == null) {
                return -1;
            }
            ProgressButton progressButton = this.f30009h;
            if (progressButton != null && progressButton.getVisibility() == 0) {
                return getTiePlusButtonState();
            }
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                return this.f30007f.getObjTypeByDownloadMode();
            }
            boolean equals = ItemCardHelper.f30256f.equals(itemData.buttonName);
            int e2 = ItemCardHelper.e(itemData.buttonName);
            if (equals) {
                return 9;
            }
            return e2;
        }
        return invokeL.intValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ItemEllipsisView extends EMTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public b f30010b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f30011c;

        /* renamed from: d  reason: collision with root package name */
        public int f30012d;

        /* loaded from: classes5.dex */
        public static class a extends LinkMovementMethod {
            public static /* synthetic */ Interceptable $ic;
            public static a a;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public static a a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                    if (a == null) {
                        a = new a();
                    }
                    return a;
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
                            ((ItemEllipsisView) textView).f30011c = true;
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

        /* loaded from: classes5.dex */
        public interface b {
            int a();

            SpannableStringBuilder b(Layout layout, boolean z);

            boolean c(int i, Layout layout);

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30011c = false;
            this.f30012d = 1;
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                super.onMeasure(i, i2);
                if (this.f30010b != null) {
                    Layout layout = getLayout();
                    int lineCount = layout.getLineCount();
                    if (lineCount > this.f30012d) {
                        if (layout.getText().toString().contains("\n")) {
                            setText(this.f30010b.b(layout, true));
                            return;
                        } else if (this.f30010b.c(lineCount, layout)) {
                            setText(this.f30010b.b(layout, false));
                            int a2 = this.f30010b.a();
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
                    SpannableStringBuilder d2 = this.f30010b.d(layout);
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
                this.f30011c = false;
                super.onTouchEvent(motionEvent);
                return this.f30011c;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f30011c) {
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
            this.f30011c = false;
            this.f30012d = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemEllipsisView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f30011c = false;
            this.f30012d = 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
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
        this.w = R.color.CAM_X0206;
        this.x = O;
        this.y = R.color.CAM_X0107;
        this.z = R.string.J_X04;
        this.A = false;
        this.B = false;
        this.D = false;
        this.G = 2;
        this.u = new Path();
        this.v = new RectF();
        E(context);
        C(context);
    }

    public void setData(ItemData itemData, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, itemData, i, str) == null) {
            setData(itemData, i, str, true);
        }
    }

    public void setData(ItemData itemData, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{itemData, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) || itemData == null) {
            return;
        }
        this.k = itemData.itemId;
        this.l = str;
        this.j = itemData.mTitle;
        this.m = itemData.mScore;
        this.n = itemData.mTags;
        ApkDetail apkDetail = itemData.apkDetail;
        if (apkDetail != null) {
            this.o = apkDetail.version;
            this.p = apkDetail.developer;
            this.q = apkDetail.privacy_url;
            this.r = apkDetail.authority_url;
        }
        this.f30003b.setText(A(this.j));
        this.a.J(itemData.mIconUrl, i, false);
        setTag(itemData.mTags);
        L();
        if (z) {
            J(itemData, str);
        }
        I(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{itemData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.f30008g.getStyleConfig();
        if (styleConfig instanceof c.a.o0.r.l0.n.c) {
            ((c.a.o0.r.l0.n.c) styleConfig).p(R.color.CAM_X0304);
        }
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.D = z;
        this.k = itemData.itemId;
        this.j = itemData.mTitle;
        this.m = itemData.mScore;
        this.n = itemData.mTags;
        ApkDetail apkDetail = itemData.apkDetail;
        if (apkDetail != null) {
            this.o = apkDetail.version;
            this.p = apkDetail.developer;
            this.q = apkDetail.privacy_url;
            this.r = apkDetail.authority_url;
        }
        this.f30007f.setClickCallback(new c(this, i2, i3, itemData));
        this.f30007f.setCustomColorBtn(SkinManager.getColor(R.color.CAM_X0303), false);
        this.f30007f.setUserProgressTextGradientModel(true);
        c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f30008g.setConfig(bVar);
        this.f30003b.setText(A(this.j));
        this.a.J(itemData.mIconUrl, i, false);
        setTag(itemData.mTags);
        L();
        J(itemData, "");
        I(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i, boolean z, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{itemData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.f30008g.getStyleConfig();
        if (styleConfig instanceof c.a.o0.r.l0.n.c) {
            ((c.a.o0.r.l0.n.c) styleConfig).p(R.color.CAM_X0304);
        }
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.D = z;
        this.k = itemData.itemId;
        this.j = itemData.mTitle;
        this.m = itemData.mScore;
        this.n = itemData.mTags;
        ApkDetail apkDetail = itemData.apkDetail;
        if (apkDetail != null) {
            this.o = apkDetail.version;
            this.p = apkDetail.developer;
            this.q = apkDetail.privacy_url;
            this.r = apkDetail.authority_url;
        }
        c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f30008g.setConfig(bVar);
        this.f30009h.setOnClickListener(new d(this, i3, i4, itemData));
        this.f30003b.setText(A(this.j));
        this.a.J(itemData.mIconUrl, i, false);
        setTag(itemData.mTags);
        L();
        M(itemData, i2);
        I(itemData.mIconSize);
    }
}
