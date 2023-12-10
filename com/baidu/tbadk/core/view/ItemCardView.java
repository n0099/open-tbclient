package com.baidu.tbadk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.cj;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.e65;
import com.baidu.tieba.f65;
import com.baidu.tieba.k65;
import com.baidu.tieba.m65;
import com.baidu.tieba.rd;
import com.baidu.tieba.u65;
import com.baidu.tieba.uua;
import com.baidu.tieba.x25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.List;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes4.dex */
public class ItemCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int N;
    public static final int O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;

    /* renamed from: T  reason: collision with root package name */
    public static final int f1075T;
    public static final int U;
    public static final int V;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public CustomMessageListener D;
    public boolean E;
    public int F;
    public String G;
    public int H;
    public int I;
    public LinearLayout J;
    public float K;
    public RadioButton L;
    public LinearLayout M;
    public TbImageView a;
    public ItemEllipsisView b;
    public ItemEllipsisView c;
    public ItemEllipsisView d;
    public ImageView e;
    public ItemCardDownloadButton f;
    public TBSpecificationBtn g;
    public ProgressButton h;
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
    public String s;
    public float t;
    public int u;
    public Path v;
    public RectF w;
    public int x;
    public int y;
    public int z;

    public void setSizeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class ItemEllipsisView extends EMTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b b;
        public boolean c;
        public int d;

        /* loaded from: classes4.dex */
        public interface b {
            int a();

            SpannableStringBuilder b(Layout layout, boolean z);

            boolean c(int i, Layout layout);

            SpannableStringBuilder d(Layout layout);
        }

        /* loaded from: classes4.dex */
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
                            ((ItemEllipsisView) textView).c = true;
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
            this.c = false;
            this.d = 1;
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
            this.c = false;
            this.d = 1;
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
            this.c = false;
            this.d = 1;
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                super.onMeasure(i, i2);
                if (this.b != null) {
                    Layout layout = getLayout();
                    int lineCount = layout.getLineCount();
                    if (lineCount > this.d) {
                        if (layout.getText().toString().contains("\n")) {
                            setText(this.b.b(layout, true));
                            return;
                        } else if (this.b.c(lineCount, layout)) {
                            setText(this.b.b(layout, false));
                            int a2 = this.b.a();
                            if (a2 > 0 && lineCount != a2) {
                                float f = a2 - lineCount;
                                setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredHeight() + (getTextSize() * f) + (getLineSpacingExtra() * f)));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    SpannableStringBuilder d = this.b.d(layout);
                    if (d != null) {
                        setText(d);
                    }
                }
            }
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                this.c = false;
                super.onTouchEvent(motionEvent);
                return this.c;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.c) {
                    return true;
                }
                return super.performClick();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int objTypeByDownloadMode = this.a.f.getObjTypeByDownloadMode();
                int intValue = this.a.f.getCurrentItem().buttonLinkType.intValue();
                if (this.a.f.getCurrentItem().apkDetail != null) {
                    i2 = this.a.f.getCurrentItem().apkDetail.pkg_source.intValue();
                } else {
                    i2 = 0;
                }
                int a = m65.a(intValue, i2);
                if (objTypeByDownloadMode > 0 && a != 4) {
                    ItemCardHelper.p(this.a.F, this.a.k, objTypeByDownloadMode, this.a.l, a, "");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.a.f.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0 && !this.a.E) {
                    int intValue = this.a.f.getCurrentItem().buttonLinkType.intValue();
                    if (this.a.f.getCurrentItem().apkDetail != null) {
                        i = this.a.f.getCurrentItem().apkDetail.pkg_source.intValue();
                    } else {
                        i = 0;
                    }
                    ItemCardHelper.p(this.a.F, this.a.k, objTypeByDownloadMode, this.a.l, m65.a(intValue, i), str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ItemData c;
        public final /* synthetic */ ItemCardView d;

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
            this.d = itemCardView;
            this.a = i;
            this.b = i2;
            this.c = itemData;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i) {
            int objTypeByDownloadMode;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (objTypeByDownloadMode = this.d.f.getObjTypeByDownloadMode()) > 0) {
                ItemCardHelper.f(this.a, this.b, objTypeByDownloadMode, 1, this.c.mTitle, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ItemData c;
        public final /* synthetic */ ItemCardView d;

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
            this.d = itemCardView;
            this.a = i;
            this.b = i2;
            this.c = itemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            ItemCardHelper.f(this.a, this.b, this.d.getTiePlusButtonState(), 2, this.c.mTitle, true);
            this.d.i.onClick(view2);
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.intValue;
            }
            return this.a.I;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                if (z) {
                    ItemCardView itemCardView = this.a;
                    return itemCardView.E(itemCardView.j);
                }
                int lineStart = layout.getLineStart(this.a.I - 1);
                int lineEnd = layout.getLineEnd(this.a.I - 1);
                TextPaint paint = this.a.b.getPaint();
                int measuredWidth = (int) (this.a.b.getMeasuredWidth() - this.a.t);
                if (!rd.isEmpty(this.a.j) && paint != null && measuredWidth > 0) {
                    while (lineEnd > 0) {
                        if (this.a.j.length() >= lineEnd) {
                            if (measuredWidth > paint.measureText(this.a.j.substring(lineStart, lineEnd - 1) + "...")) {
                                break;
                            }
                        }
                        lineEnd--;
                    }
                    if (lineEnd > 0) {
                        return this.a.E(this.a.j.substring(0, lineEnd - 1) + "...");
                    }
                    ItemCardView itemCardView2 = this.a;
                    return itemCardView2.E(itemCardView2.j);
                }
                ItemCardView itemCardView3 = this.a;
                return itemCardView3.E(itemCardView3.j);
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public boolean c(int i, Layout layout) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, layout)) == null) {
                if (layout == null || i <= this.a.I) {
                    return false;
                }
                return true;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder d(Layout layout) {
            InterceptResult invokeL;
            int width;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layout)) == null) {
                int lineCount = layout.getLineCount();
                if (lineCount != 0 && lineCount != 1) {
                    TextPaint paint = this.a.b.getPaint();
                    if (this.a.b.getWidth() == 0) {
                        width = this.a.b.getMeasuredWidth();
                    } else {
                        width = this.a.b.getWidth();
                    }
                    float measureText = paint.measureText(this.a.j.substring(layout.getLineStart(lineCount - 2)));
                    float f = width;
                    if (measureText <= f && measureText > f - this.a.t) {
                        ItemCardView itemCardView = this.a;
                        return itemCardView.F(itemCardView.j, true);
                    }
                }
                return null;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardView a;

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
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            int width;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (this.a.c.getWidth() == 0) {
                    width = this.a.c.getMeasuredWidth();
                } else {
                    width = this.a.c.getWidth();
                }
                if (width <= 0) {
                    width = Integer.MAX_VALUE;
                }
                TextPaint paint = this.a.c.getPaint();
                if (paint == null) {
                    return spannableStringBuilder;
                }
                if (!rd.isEmpty(this.a.o)) {
                    width -= (int) (ItemCardView.U + paint.measureText(((Object) this.a.getContext().getText(R.string.item_version)) + this.a.o));
                }
                if (ListUtils.getCount(this.a.n) > 0) {
                    for (int i = 0; i < this.a.n.size(); i++) {
                        if (!rd.isEmpty((String) this.a.n.get(i))) {
                            float measureText = width - paint.measureText(((String) this.a.n.get(i)) + " ");
                            if (measureText <= 0.0f) {
                                break;
                            }
                            spannableStringBuilder.append((CharSequence) this.a.n.get(i));
                            spannableStringBuilder.append((CharSequence) " ");
                            width = (int) measureText;
                        }
                    }
                }
                if (!rd.isEmpty(this.a.o)) {
                    if (spannableStringBuilder.length() > 1) {
                        spannableStringBuilder.setSpan(new u65(ItemCardView.U), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    }
                    spannableStringBuilder.append(this.a.getContext().getText(R.string.item_version));
                    spannableStringBuilder.append((CharSequence) this.a.o);
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ItemEllipsisView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ ItemCardView b;

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder d(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layout)) == null) {
                return null;
            }
            return (SpannableStringBuilder) invokeL.objValue;
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
            this.b = itemCardView;
            this.a = 1;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardView.ItemEllipsisView.b
        public SpannableStringBuilder b(Layout layout, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layout, z)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!rd.isEmpty(this.b.q) || !rd.isEmpty(this.b.r) || !rd.isEmpty(this.b.s)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " |");
                    int i = length + 1;
                    spannableStringBuilder.setSpan(new u65(ItemCardView.V), length, i, 33);
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X10), new ColorStateList(new int[][]{new int[0]}, new int[]{uua.a(SkinManager.getColor(R.color.CAM_X0108), x25.b(R.string.A_X10))}), null), i, length + 2, 33);
                    if (!rd.isEmpty(this.b.q)) {
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.b.getContext().getString(R.string.item_download_privacy));
                        int i2 = length2 + 1;
                        spannableStringBuilder.setSpan(new u65(ItemCardView.V), length2, i2, 33);
                        spannableStringBuilder.setSpan(new k(this.b.getContext(), this.b.q), i2, length2 + 3, 33);
                    }
                    if (!rd.isEmpty(this.b.r)) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.b.getContext().getString(R.string.item_download_authority));
                        int i3 = length3 + 1;
                        spannableStringBuilder.setSpan(new u65(ItemCardView.V), length3, i3, 33);
                        spannableStringBuilder.setSpan(new k(this.b.getContext(), this.b.r), i3, length3 + 3, 33);
                    }
                    if (!rd.isEmpty(this.b.s)) {
                        int length4 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.b.getContext().getString(R.string.item_download_effect));
                        int i4 = length4 + 1;
                        spannableStringBuilder.setSpan(new u65(ItemCardView.V), length4, i4, 33);
                        spannableStringBuilder.setSpan(new k(this.b.getContext(), this.b.s), i4, length4 + 3, 33);
                    }
                }
                if (layout == null) {
                    spannableStringBuilder.insert(0, (CharSequence) this.b.p);
                    spannableStringBuilder.setSpan(new j(this.b.getContext(), this.b.p), 0, this.b.p.length(), 33);
                    return spannableStringBuilder;
                }
                TextPaint paint = this.b.d.getPaint();
                if (this.b.p != null && paint != null) {
                    this.b.u = spannableStringBuilder.length();
                    float measureText = paint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
                    int measuredWidth = this.b.d.getMeasuredWidth();
                    int lineCount = layout.getLineCount();
                    this.a = lineCount;
                    if (lineCount > 1 && !rd.isEmpty(this.b.p)) {
                        int length5 = this.b.p.length();
                        do {
                            length5--;
                        } while (paint.measureText(this.b.p.substring(0, length5) + "...") + measureText > measuredWidth);
                        this.a = 1;
                        String str = this.b.p.substring(0, length5) + "...";
                        spannableStringBuilder.insert(0, (CharSequence) str);
                        spannableStringBuilder.setSpan(new j(this.b.getContext(), this.b.p), 0, str.length(), 33);
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
                if (layout != null && i > 1 && !rd.isEmpty(this.b.p)) {
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardView a;

        public h(ItemCardView itemCardView) {
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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = this.a.K * (((Float) valueAnimator.getAnimatedValue()).floatValue() / 300.0f);
                this.a.L.setTranslationX(floatValue);
                this.a.a.setTranslationX(floatValue);
                this.a.J.setTranslationX(floatValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardView a;

        public i(ItemCardView itemCardView) {
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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = this.a.K * (1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() / 300.0f));
                this.a.L.setTranslationX(floatValue);
                this.a.a.setTranslationX(floatValue);
                this.a.J.setTranslationX(floatValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;
        public String b;

        public j(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(context);
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a.get();
                if (!rd.isEmpty(this.b) && context != null && (a5.a(context) instanceof TbPageContext)) {
                    BdUtilHelper.showToast(this.b, 2000, true);
                }
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

    /* loaded from: classes4.dex */
    public static class k extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;
        public String b;

        public k(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(context);
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a.get();
                if (!rd.isEmpty(this.b) && context != null && (a5.a(context) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) a5.a(context), new String[]{this.b});
                }
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
        N = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        O = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        P = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        Q = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        R = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        S = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        f1075T = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        U = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004);
        V = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTiePlusButtonState() {
        InterceptResult invokeV;
        int q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ProgressButton progressButton = this.h;
            if (progressButton == null || progressButton.getVisibility() != 0) {
                return -1;
            }
            TiePlusHelper tiePlusHelper = this.i;
            if (tiePlusHelper != null && tiePlusHelper.A() != null) {
                DownloadData A = this.i.A();
                if ((A.getItemData() == null || !StringUtils.isNotNull(A.getItemData().pkgName) || !this.i.J(A)) && (q = this.i.D(A).q(A)) != 0) {
                    if (q == 1) {
                        return 8;
                    }
                    if (q != 3) {
                        if (q != 4) {
                            if (q == 5) {
                                return 8;
                            }
                            if (q == 6 || q != 7) {
                                return 2;
                            }
                        }
                        return 7;
                    }
                }
                return 5;
            } else if (!(this.h.getTag() instanceof Byte)) {
                return -1;
            } else {
                byte byteValue = ((Byte) this.h.getTag()).byteValue();
                if (byteValue != 0) {
                    if (byteValue != 1) {
                        if (byteValue != 2) {
                            if (byteValue != 3) {
                                if (byteValue != 4) {
                                    return -1;
                                }
                                return 5;
                            }
                            return 7;
                        }
                        return 4;
                    }
                    return 8;
                }
                return 2;
            }
        }
        return invokeV.intValue;
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
        if (interceptable == null || interceptable.invokeL(65563, this, list) == null) {
            if ((list == null || list.isEmpty() || !L(list)) && rd.isEmpty(this.o)) {
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.c;
            itemEllipsisView.setText(itemEllipsisView.b.b(null, false));
        }
    }

    public void G(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            if (f2 == 300.0f) {
                this.L.setTranslationX(0.0f);
                this.a.setTranslationX(0.0f);
                this.J.setTranslationX(0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 300.0f);
            ofFloat.setDuration(300.0f - f2);
            ofFloat.addUpdateListener(new i(this));
            ofFloat.start();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.v.reset();
            this.w.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            Path path = this.v;
            RectF rectF = this.w;
            int i2 = this.y;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            canvas.clipPath(this.v);
            super.draw(canvas);
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
        this.x = R.color.CAM_X0206;
        this.y = f1075T;
        this.z = R.color.CAM_X0107;
        this.A = R.string.J_X04;
        this.B = false;
        this.C = false;
        this.E = false;
        this.I = 2;
        this.v = new Path();
        this.w = new RectF();
        K(context);
        I(context);
    }

    private void setMaxLinesByItemButtonName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, str) == null) {
            if (ItemCardHelper.b.equals(str)) {
                this.I = 1;
            } else {
                this.I = 2;
            }
            this.b.d = this.I;
        }
    }

    public final SpannableStringBuilder E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return F(str, false);
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final void I(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            b bVar = new b(this, 2921609);
            this.D = bVar;
            bVar.setTag(this.f.getTag());
            this.D.setSelfListener(true);
        }
    }

    public final boolean L(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, list)) == null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setBackGroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.x = i2;
            M();
        }
    }

    public void setFirstLineTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.z = i2;
            M();
        }
    }

    public void setHighLightText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.G = str;
        }
    }

    public void setIsShowRightBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.B = z;
            if (z && !this.C) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void setItemImageViewRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.A = i2;
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setRadiusById(i2);
            }
        }
    }

    public void setOnClickListenerOfRightBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.g.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.F = i2;
        }
    }

    public void setRadioSelected(boolean z) {
        RadioButton radioButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (radioButton = this.L) != null) {
            radioButton.setChecked(z);
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.y = i2;
            postInvalidate();
        }
    }

    public void setSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.H = i2;
        }
    }

    public final void Q(Item item, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, item, str) != null) || item == null) {
            return;
        }
        ItemData itemData = new ItemData();
        itemData.parseProto(item);
        P(itemData, str);
    }

    public void setData(ItemData itemData, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048600, this, itemData, i2, str) == null) {
            setData(itemData, i2, str, true);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RadioButton radioButton = this.L;
            if (radioButton != null) {
                radioButton.setTranslationX(0.0f);
            }
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setTranslationX(0.0f);
            }
            LinearLayout linearLayout = this.J;
            if (linearLayout != null) {
                linearLayout.setTranslationX(0.0f);
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.e.setVisibility(0);
        }
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public int D(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemData)) == null) {
            if (itemData == null) {
                return -1;
            }
            ProgressButton progressButton = this.h;
            if (progressButton != null && progressButton.getVisibility() == 0) {
                return getTiePlusButtonState();
            }
            if (ItemCardHelper.x(itemData) && ItemCardHelper.o(itemData)) {
                return this.f.getObjTypeByDownloadMode();
            }
            boolean equals = ItemCardHelper.f.equals(itemData.buttonName);
            int e2 = ItemCardHelper.e(itemData.buttonName);
            if (equals) {
                return 9;
            }
            return e2;
        }
        return invokeL.intValue;
    }

    public final void O(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            if (d2 != 1.0d && d2 > 0.0d) {
                if (d2 < 1.0d) {
                    layoutParams.width = P;
                    layoutParams.height = Q;
                } else {
                    layoutParams.width = R;
                    layoutParams.height = S;
                }
            } else {
                layoutParams.width = N;
                layoutParams.height = O;
            }
            this.a.setLayoutParams(layoutParams);
        }
    }

    public void U(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            if (f2 == 300.0f) {
                this.L.setTranslationX(this.K);
                this.a.setTranslationX(this.K);
                this.J.setTranslationX(this.K);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 300.0f);
            ofFloat.setDuration(300.0f - f2);
            ofFloat.addUpdateListener(new h(this));
            ofFloat.start();
        }
    }

    public final SpannableStringBuilder F(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (rd.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = str;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            this.t = 0.0f;
            if (!TextUtils.isEmpty(this.G)) {
                UtilHelper.setSpan(spannableStringBuilder, str, this.G, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            }
            double d2 = this.m;
            if (d2 > 0.0d && d2 <= 10.0d) {
                int length = spannableStringBuilder.length();
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_small_star, R.color.CAM_X0305, EMRichTextAnyIconSpan.IconType.WEBP);
                if (z) {
                    eMRichTextAnyIconSpan.f(-UtilHelper.getDimenPixelSize(R.dimen.tbds2));
                } else {
                    eMRichTextAnyIconSpan.f(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
                }
                eMRichTextAnyIconSpan.j(UtilHelper.getDimenPixelSize(R.dimen.tbds7));
                eMRichTextAnyIconSpan.k(UtilHelper.getDimenPixelSize(R.dimen.tbds6));
                eMRichTextAnyIconSpan.l(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
                if (z) {
                    spannableStringBuilder.append((CharSequence) "\n ");
                } else {
                    spannableStringBuilder.append((CharSequence) " ");
                }
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                String format = new DecimalFormat(cj.d).format(this.m);
                TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X09), SkinManager.getColorList(R.color.CAM_X0305), null);
                spannableStringBuilder.append((CharSequence) format);
                spannableStringBuilder.setSpan(textAppearanceSpan, spannableStringBuilder.length() - format.length(), spannableStringBuilder.length(), 33);
                TextPaint paint = this.b.getPaint();
                if (length == 0) {
                    i2 = 0;
                } else {
                    i2 = length - 1;
                }
                this.t = paint.measureText(spannableStringBuilder, i2, spannableStringBuilder.length());
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void S(ItemData itemData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, itemData, i2) != null) || itemData == null) {
            return;
        }
        if ((!ItemCardHelper.x(itemData) || !ItemCardHelper.o(itemData)) && i2 != 1 && !"app".equals(itemData.fileType)) {
            this.C = false;
            this.f.setVisibility(8);
            this.h.setVisibility(8);
            if (this.B) {
                k65 k65Var = new k65(itemData, this.F, "");
                ItemCardHelper.n(this.g, k65Var);
                itemData = k65Var.a();
                this.g.setText(itemData.buttonName);
                this.g.k();
            }
            setIsShowRightBtn(this.B);
        } else {
            this.h.setVisibility(0);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            this.i.b0(itemData);
            StringBuilder sb = new StringBuilder();
            sb.append(itemData.pkgName);
            sb.append(".v");
            ApkDetail apkDetail = itemData.apkDetail;
            if (apkDetail != null) {
                sb.append(apkDetail.version);
            }
            DownloadData downloadData = new DownloadData(sb.toString());
            downloadData.setUrl(itemData.buttonLink);
            downloadData.setName(itemData.mTitle);
            downloadData.setSource(2);
            downloadData.setType(12);
            downloadData.setItemData(itemData);
            this.i.X(downloadData);
            TiePlusHelper tiePlusHelper = this.i;
            tiePlusHelper.S(itemData.appId);
            tiePlusHelper.Y(itemData.buttonLink);
            tiePlusHelper.c0(itemData.pkgName);
            if (this.i.A() == null) {
                TiePlusHelper tiePlusHelper2 = this.i;
                tiePlusHelper2.r0(tiePlusHelper2.C(), this.i.y(), getContext(), this.h);
            } else {
                this.i.q0(this.h, null);
            }
        }
        setMaxLinesByItemButtonName(itemData.buttonName);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RadioButton radioButton = new RadioButton(getContext());
            this.L = radioButton;
            radioButton.setBackground(SkinManager.getDrawable(R.drawable.download_item_selector));
            this.L.setButtonDrawable((Drawable) null);
            this.L.setFocusable(false);
            this.L.setClickable(false);
            this.L.setChecked(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds62), UtilHelper.getDimenPixelSize(R.dimen.tbds62));
            int i2 = -(UtilHelper.getDimenPixelSize(R.dimen.tbds62) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            layoutParams.setMarginStart(i2);
            layoutParams.setMarginEnd(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003));
            layoutParams.gravity = 16;
            this.K = (-i2) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            this.L.setLayoutParams(layoutParams);
            this.M.addView(this.L, 0);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SkinManager.setBackgroundColor(this, this.x);
            EMManager.from(this.b).setTextColor(this.z);
            EMManager.from(this.c).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.d).setTextLinePadding(R.dimen.M_T_X001).setTextColor(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.a.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a.setPlaceHolder(1);
            this.g.k();
            this.f.v();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o = "";
            this.p = "";
            this.q = "";
            this.r = "";
            this.s = "";
            this.x = R.color.CAM_X0206;
            this.y = f1075T;
            this.z = R.color.CAM_X0107;
            this.A = R.string.J_X04;
            this.B = false;
            this.C = false;
            this.E = false;
            this.I = 2;
            f65 f65Var = new f65();
            f65Var.r(R.color.CAM_X0304);
            this.g.setConfig(f65Var);
            this.a.setDrawCorner(true);
            this.a.setConrers(15);
            this.a.setRadiusById(this.A);
            this.a.setPlaceHolder(1);
            this.a.setDrawBorder(true);
            this.h.setUseLongText(false);
            this.h.setVisibility(8);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.b = new e(this);
            ItemEllipsisView itemEllipsisView = this.b;
            itemEllipsisView.d = itemEllipsisView.b.a();
            this.c.b = new f(this);
            this.d.b = new g(this);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (rd.isEmpty(this.p) && rd.isEmpty(this.q) && rd.isEmpty(this.r)) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.d;
            itemEllipsisView.setText(itemEllipsisView.b.b(null, false));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.D);
            if (this.i.A() == null) {
                MessageManager.getInstance().registerListener(this.i);
                return;
            }
            TiePlusHelper tiePlusHelper = this.i;
            tiePlusHelper.D(tiePlusHelper.A()).g(this.i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.D);
            if (this.i.A() == null) {
                MessageManager.getInstance().unRegisterListener(this.i);
                return;
            }
            TiePlusHelper tiePlusHelper = this.i;
            tiePlusHelper.D(tiePlusHelper.A()).u(this.i);
        }
    }

    public final void K(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            context.getString(R.string.limited_company);
            LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
            this.M = (LinearLayout) findViewById(R.id.item_root);
            this.a = (TbImageView) findViewById(R.id.item_image);
            this.b = (ItemEllipsisView) findViewById(R.id.first_info);
            this.c = (ItemEllipsisView) findViewById(R.id.second_info);
            ItemEllipsisView itemEllipsisView = (ItemEllipsisView) findViewById(R.id.third_info);
            this.d = itemEllipsisView;
            itemEllipsisView.setMovementMethod(ItemEllipsisView.a.a());
            this.e = (ImageView) findViewById(R.id.bt_del);
            this.f = (ItemCardDownloadButton) findViewById(R.id.order_download_btn);
            this.J = (LinearLayout) findViewById(R.id.item_center_container);
            this.f.setClickCallback(new a(this));
            this.g = (TBSpecificationBtn) findViewById(R.id.order_or_download);
            f65 f65Var = new f65();
            f65Var.r(R.color.CAM_X0304);
            this.g.setConfig(f65Var);
            this.a.setDrawCorner(true);
            this.a.setConrers(15);
            this.a.setRadiusById(this.A);
            this.a.setPlaceHolder(1);
            this.a.setDrawBorder(true);
            H();
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tie_plus_download_btn);
            this.h = progressButton;
            progressButton.setUseLongText(false);
            this.h.setVisibility(8);
            TiePlusHelper tiePlusHelper = new TiePlusHelper(getContext());
            this.i = tiePlusHelper;
            tiePlusHelper.p(this.h);
            M();
            J();
        }
    }

    public final void P(ItemData itemData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, itemData, str) != null) || itemData == null) {
            return;
        }
        this.h.setVisibility(8);
        if ((ItemCardHelper.x(itemData) && ItemCardHelper.o(itemData)) || "app".equals(itemData.fileType)) {
            this.C = true;
            this.f.setData(itemData, this.F, str, this.H);
            this.f.setVisibility(0);
            int objTypeByDownloadMode = this.f.getObjTypeByDownloadMode();
            if (objTypeByDownloadMode > 0 && !this.E) {
                ItemCardHelper.r(this.F, itemData.itemId, objTypeByDownloadMode, str);
            }
        } else {
            this.C = false;
            this.f.setVisibility(8);
            if (this.B) {
                k65 k65Var = new k65(itemData, this.F, str);
                boolean equals = ItemCardHelper.f.equals(itemData.buttonName);
                ItemCardHelper.n(this.g, k65Var);
                ItemData a2 = k65Var.a();
                this.g.setText(a2.buttonName);
                this.g.k();
                int e2 = ItemCardHelper.e(a2.buttonName);
                if (-1 != e2 && !this.E) {
                    int i2 = this.F;
                    long j2 = a2.itemId;
                    if (equals) {
                        e2 = 9;
                    }
                    ItemCardHelper.r(i2, j2, e2, str);
                }
                itemData = a2;
            }
        }
        setMaxLinesByItemButtonName(itemData.buttonName);
        setIsShowRightBtn(this.B);
    }

    public void setData(ItemData itemData, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048601, this, new Object[]{itemData, Integer.valueOf(i2), str, Boolean.valueOf(z)}) != null) || itemData == null) {
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
            this.s = apkDetail.app_effect;
        }
        this.b.setText(E(this.j));
        this.a.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        R();
        if (z) {
            P(itemData, str);
        }
        O(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i2, boolean z, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048602, this, new Object[]{itemData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.g.getStyleConfig();
        if (styleConfig instanceof f65) {
            ((f65) styleConfig).r(R.color.CAM_X0304);
        }
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.E = z;
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
            this.s = apkDetail.app_effect;
        }
        this.f.setClickCallback(new c(this, i3, i4, itemData));
        this.f.setCustomColorBtn(SkinManager.getColor(R.color.CAM_X0303), false);
        this.f.setUserProgressTextGradientModel(true);
        e65 e65Var = new e65();
        e65Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
        this.g.setConfig(e65Var);
        this.b.setText(E(this.j));
        this.a.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        R();
        P(itemData, "");
        O(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i2, boolean z, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048603, this, new Object[]{itemData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) != null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.g.getStyleConfig();
        if (styleConfig instanceof f65) {
            ((f65) styleConfig).r(R.color.CAM_X0304);
        }
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.E = z;
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
            this.s = apkDetail.app_effect;
        }
        e65 e65Var = new e65();
        e65Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
        this.g.setConfig(e65Var);
        this.h.setOnClickListener(new d(this, i4, i5, itemData));
        this.b.setText(E(this.j));
        this.a.startLoad(itemData.mIconUrl, i2, false);
        setTag(itemData.mTags);
        R();
        S(itemData, i3);
        O(itemData.mIconSize);
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048604, this, tbRichTextEvaluateItemInfo, i2, str) != null) || tbRichTextEvaluateItemInfo == null) {
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
                this.s = tbRichTextEvaluateItemInfo.getItem().apk_detail.app_effect;
            }
        }
        this.b.setText(E(this.j));
        this.a.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i2, false);
        setTag(tbRichTextEvaluateItemInfo.getTags());
        R();
        Q(tbRichTextEvaluateItemInfo.getItem(), str);
        O(tbRichTextEvaluateItemInfo.getIconSize());
    }
}
