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
import com.baidu.tieba.da;
import com.baidu.tieba.dj;
import com.baidu.tieba.e55;
import com.baidu.tieba.ej;
import com.baidu.tieba.lz8;
import com.baidu.tieba.n15;
import com.baidu.tieba.n45;
import com.baidu.tieba.o45;
import com.baidu.tieba.p15;
import com.baidu.tieba.u45;
import com.baidu.tieba.w45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes3.dex */
public class ItemCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int J;
    public static final int K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public CustomMessageListener C;
    public boolean D;
    public int E;
    public String F;
    public int G;
    public int H;
    public String I;
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
    public float s;
    public int t;
    public Path u;
    public RectF v;
    public int w;
    public int x;
    public int y;
    public int z;

    public void setSizeStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class ItemEllipsisView extends EMTextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b b;
        public boolean c;
        public int d;

        /* loaded from: classes3.dex */
        public interface b {
            int a();

            SpannableStringBuilder b(Layout layout, boolean z);

            boolean c(int i, Layout layout);

            SpannableStringBuilder d(Layout layout);
        }

        /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        public void a(int i) {
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
                int a = w45.a(intValue, i2);
                if (objTypeByDownloadMode > 0 && a != 4) {
                    ItemCardHelper.p(this.a.E, this.a.k, objTypeByDownloadMode, this.a.l, a, "");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (objTypeByDownloadMode > 0 && !this.a.D) {
                    int intValue = this.a.f.getCurrentItem().buttonLinkType.intValue();
                    if (this.a.f.getCurrentItem().apkDetail != null) {
                        i = this.a.f.getCurrentItem().apkDetail.pkg_source.intValue();
                    } else {
                        i = 0;
                    }
                    ItemCardHelper.p(this.a.E, this.a.k, objTypeByDownloadMode, this.a.l, w45.a(intValue, i), str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(int i) {
            int objTypeByDownloadMode;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (objTypeByDownloadMode = this.d.f.getObjTypeByDownloadMode()) > 0) {
                ItemCardHelper.f(this.a, this.b, objTypeByDownloadMode, 1, this.c.mTitle, true);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            return this.a.H;
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
                int lineStart = layout.getLineStart(this.a.H - 1);
                int lineEnd = layout.getLineEnd(this.a.H - 1);
                TextPaint paint = this.a.b.getPaint();
                int measuredWidth = (int) (this.a.b.getMeasuredWidth() - this.a.s);
                if (!dj.isEmpty(this.a.j) && paint != null && measuredWidth > 0) {
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
                    ItemCardView itemCardView2 = this.a;
                    return itemCardView2.A(itemCardView2.j);
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
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, layout)) == null) {
                if (layout == null || i <= this.a.H) {
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
                    if (measureText <= f && measureText > f - this.a.s) {
                        ItemCardView itemCardView = this.a;
                        return itemCardView.B(itemCardView.j, true);
                    }
                }
                return null;
            }
            return (SpannableStringBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                if (!dj.isEmpty(this.a.o)) {
                    width -= (int) (ItemCardView.Q + paint.measureText(((Object) this.a.getContext().getText(R.string.item_version)) + this.a.o));
                }
                if (ListUtils.getCount(this.a.n) > 0) {
                    for (int i = 0; i < this.a.n.size(); i++) {
                        if (!dj.isEmpty((String) this.a.n.get(i))) {
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
                if (!dj.isEmpty(this.a.o)) {
                    if (spannableStringBuilder.length() > 1) {
                        spannableStringBuilder.setSpan(new e55(ItemCardView.Q), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    }
                    spannableStringBuilder.append(this.a.getContext().getText(R.string.item_version));
                    spannableStringBuilder.append((CharSequence) this.a.o);
                }
                return spannableStringBuilder;
            }
            return (SpannableStringBuilder) invokeLZ.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                if (!dj.isEmpty(this.b.q) || !dj.isEmpty(this.b.r)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " |");
                    int i = length + 1;
                    spannableStringBuilder.setSpan(new e55(ItemCardView.R), length, i, 33);
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X10), new ColorStateList(new int[][]{new int[0]}, new int[]{lz8.a(SkinManager.getColor(R.color.CAM_X0108), n15.b(R.string.A_X10))}), null), i, length + 2, 33);
                    if (!dj.isEmpty(this.b.q)) {
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.b.getContext().getString(R.string.item_download_privacy));
                        int i2 = length2 + 1;
                        spannableStringBuilder.setSpan(new e55(ItemCardView.R), length2, i2, 33);
                        spannableStringBuilder.setSpan(new h(this.b.getContext(), this.b.q), i2, length2 + 3, 33);
                    }
                    if (!dj.isEmpty(this.b.r)) {
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.append((CharSequence) this.b.getContext().getString(R.string.item_download_authority));
                        int i3 = length3 + 1;
                        spannableStringBuilder.setSpan(new e55(ItemCardView.R), length3, i3, 33);
                        spannableStringBuilder.setSpan(new h(this.b.getContext(), this.b.r), i3, length3 + 3, 33);
                    }
                }
                if (layout == null) {
                    spannableStringBuilder.insert(0, (CharSequence) this.b.p);
                    return spannableStringBuilder;
                }
                TextPaint paint = this.b.d.getPaint();
                if (this.b.p != null && paint != null) {
                    this.b.t = spannableStringBuilder.length();
                    float measureText = paint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
                    int measuredWidth = this.b.d.getMeasuredWidth();
                    int lineCount = layout.getLineCount();
                    this.a = lineCount;
                    if (lineCount == 2 && this.b.p != null && this.b.p.endsWith(this.b.I) && paint.measureText(this.b.p.substring(0, this.b.p.length() - 4)) + measureText <= measuredWidth) {
                        this.a = 1;
                        spannableStringBuilder.insert(0, (CharSequence) this.b.p.substring(0, this.b.p.length() - 4));
                        return spannableStringBuilder;
                    }
                    int i4 = this.a;
                    if (i4 > 0) {
                        int lineEnd = layout.getLineEnd(i4 - 1) - layout.getLineStart(this.a - 1);
                        spannableStringBuilder.insert(0, (CharSequence) this.b.p);
                        if (lineEnd < this.b.t) {
                            spannableStringBuilder.insert(this.b.p.length(), (CharSequence) "\n");
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
                    if (i == 2 && this.b.p != null && this.b.p.endsWith(this.b.I)) {
                        return true;
                    }
                    if (i > 0) {
                        int i2 = i - 1;
                        if (layout.getLineEnd(i2) - layout.getLineStart(i2) < this.b.t) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;
        public String b;

        public h(Context context, String str) {
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
                if (!dj.isEmpty(this.b) && context != null && (da.a(context) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) da.a(context), new String[]{this.b});
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
        J = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        K = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        L = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        M = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        N = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
        O = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
        P = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        Q = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004);
        R = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
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

    private void setTag(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, list) == null) {
            if ((list == null || list.isEmpty() || !F(list)) && dj.isEmpty(this.o)) {
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.c;
            itemEllipsisView.setText(itemEllipsisView.b.b(null, false));
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
        this.x = P;
        this.y = R.color.CAM_X0107;
        this.z = R.string.J_X04;
        this.A = false;
        this.B = false;
        this.D = false;
        this.H = 2;
        this.u = new Path();
        this.v = new RectF();
        E(context);
        C(context);
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048599, this, tbRichTextEvaluateItemInfo, i, str) != null) || tbRichTextEvaluateItemInfo == null) {
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
        this.b.setText(A(this.j));
        this.a.K(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        setTag(tbRichTextEvaluateItemInfo.getTags());
        L();
        K(tbRichTextEvaluateItemInfo.getItem(), str);
        I(tbRichTextEvaluateItemInfo.getIconSize());
    }

    private void setMaxLinesByItemButtonName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
            if (ItemCardHelper.b.equals(str)) {
                this.H = 1;
            } else {
                this.H = 2;
            }
            this.b.d = this.H;
        }
    }

    public final SpannableStringBuilder A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return B(str, false);
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            b bVar = new b(this, 2921609);
            this.C = bVar;
            bVar.setTag(this.f.getTag());
            this.C.setSelfListener(true);
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

    public void setBackGroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.w = i;
            G();
        }
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
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
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
            this.g.setOnClickListener(onClickListener);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
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

    public void setSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.G = i;
        }
    }

    public final void K(Item item, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, item, str) != null) || item == null) {
            return;
        }
        ItemData itemData = new ItemData();
        itemData.parseProto(item);
        J(itemData, str);
    }

    public void setData(ItemData itemData, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, itemData, i, str) == null) {
            setData(itemData, i, str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTiePlusButtonState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            ProgressButton progressButton = this.h;
            if (progressButton == null || progressButton.getVisibility() != 0) {
                return -1;
            }
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
        return invokeV.intValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.b = new e(this);
            ItemEllipsisView itemEllipsisView = this.b;
            itemEllipsisView.d = itemEllipsisView.b.a();
            this.c.b = new f(this);
            this.d.b = new g(this);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (dj.isEmpty(this.p) && dj.isEmpty(this.q) && dj.isEmpty(this.r)) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            ItemEllipsisView itemEllipsisView = this.d;
            itemEllipsisView.setText(itemEllipsisView.b.b(null, false));
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.setVisibility(0);
        }
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.E;
        }
        return invokeV.intValue;
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

    public final SpannableStringBuilder B(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (dj.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = str;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            this.s = 0.0f;
            if (!TextUtils.isEmpty(this.F)) {
                UtilHelper.setSpan(spannableStringBuilder, str, this.F, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            }
            double d2 = this.m;
            if (d2 > 0.0d && d2 <= 10.0d) {
                int length = spannableStringBuilder.length();
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_small_star, R.color.CAM_X0305, EMRichTextAnyIconSpan.IconType.WEBP);
                if (z) {
                    eMRichTextAnyIconSpan.d(-UtilHelper.getDimenPixelSize(R.dimen.tbds2));
                } else {
                    eMRichTextAnyIconSpan.d(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
                }
                eMRichTextAnyIconSpan.f(UtilHelper.getDimenPixelSize(R.dimen.tbds7));
                eMRichTextAnyIconSpan.g(UtilHelper.getDimenPixelSize(R.dimen.tbds6));
                eMRichTextAnyIconSpan.h(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
                if (z) {
                    spannableStringBuilder.append((CharSequence) "\n ");
                } else {
                    spannableStringBuilder.append((CharSequence) " ");
                }
                spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                String str3 = this.m + "";
                TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.DEFAULT.getStyle(), UtilHelper.getDimenPixelSize(R.dimen.T_X09), SkinManager.getColorList(R.color.CAM_X0305), null);
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.setSpan(textAppearanceSpan, spannableStringBuilder.length() - str3.length(), spannableStringBuilder.length(), 33);
                TextPaint paint = this.b.getPaint();
                if (length == 0) {
                    i = 0;
                } else {
                    i = length - 1;
                }
                this.s = paint.measureText(spannableStringBuilder, i, spannableStringBuilder.length());
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.I = context.getString(R.string.limited_company);
            LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
            this.a = (TbImageView) findViewById(R.id.item_image);
            this.b = (ItemEllipsisView) findViewById(R.id.first_info);
            this.c = (ItemEllipsisView) findViewById(R.id.second_info);
            ItemEllipsisView itemEllipsisView = (ItemEllipsisView) findViewById(R.id.third_info);
            this.d = itemEllipsisView;
            itemEllipsisView.setMovementMethod(ItemEllipsisView.a.a());
            this.e = (ImageView) findViewById(R.id.bt_del);
            ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) findViewById(R.id.order_download_btn);
            this.f = itemCardDownloadButton;
            itemCardDownloadButton.setClickCallback(new a(this));
            this.g = (TBSpecificationBtn) findViewById(R.id.order_or_download);
            o45 o45Var = new o45();
            o45Var.q(R.color.CAM_X0304);
            this.g.setConfig(o45Var);
            this.a.setDrawCorner(true);
            this.a.setConrers(15);
            this.a.setRadiusById(this.z);
            this.a.setPlaceHolder(1);
            this.a.setDrawBorder(true);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tie_plus_download_btn);
            this.h = progressButton;
            progressButton.setUseLongText(false);
            this.h.setVisibility(8);
            TiePlusHelper tiePlusHelper = new TiePlusHelper(getContext());
            this.i = tiePlusHelper;
            tiePlusHelper.i(this.h);
            G();
            D();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this, this.w);
            p15.d(this.b).v(this.y);
            p15.d(this.c).v(R.color.CAM_X0109);
            p15 d2 = p15.d(this.d);
            d2.w(R.dimen.M_T_X001);
            d2.v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.a.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a.setPlaceHolder(1);
            this.g.k();
            this.f.v();
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
            this.x = P;
            this.y = R.color.CAM_X0107;
            this.z = R.string.J_X04;
            this.A = false;
            this.B = false;
            this.D = false;
            this.H = 2;
            o45 o45Var = new o45();
            o45Var.q(R.color.CAM_X0304);
            this.g.setConfig(o45Var);
            this.a.setDrawCorner(true);
            this.a.setConrers(15);
            this.a.setRadiusById(this.z);
            this.a.setPlaceHolder(1);
            this.a.setDrawBorder(true);
            this.h.setUseLongText(false);
            this.h.setVisibility(8);
        }
    }

    public final void I(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            if (d2 != 1.0d && d2 > 0.0d) {
                if (d2 < 1.0d) {
                    layoutParams.width = L;
                    layoutParams.height = M;
                } else {
                    layoutParams.width = N;
                    layoutParams.height = O;
                }
            } else {
                layoutParams.width = J;
                layoutParams.height = K;
            }
            this.a.setLayoutParams(layoutParams);
        }
    }

    public int z(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, itemData)) == null) {
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

    public final void J(ItemData itemData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, itemData, str) != null) || itemData == null) {
            return;
        }
        this.h.setVisibility(8);
        if (ItemCardHelper.x(itemData) && ItemCardHelper.o(itemData)) {
            this.B = true;
            this.f.setData(itemData, this.E, str, this.G);
            this.f.setVisibility(0);
            int objTypeByDownloadMode = this.f.getObjTypeByDownloadMode();
            if (objTypeByDownloadMode > 0 && !this.D) {
                ItemCardHelper.r(this.E, itemData.itemId, objTypeByDownloadMode, str);
            }
        } else {
            this.B = false;
            this.f.setVisibility(8);
            if (this.A) {
                u45 u45Var = new u45(itemData, this.E, str);
                boolean equals = ItemCardHelper.f.equals(itemData.buttonName);
                ItemCardHelper.n(this.g, u45Var);
                ItemData a2 = u45Var.a();
                this.g.setText(a2.buttonName);
                this.g.k();
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

    public final void M(ItemData itemData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048588, this, itemData, i) != null) || itemData == null) {
            return;
        }
        if ((ItemCardHelper.x(itemData) && ItemCardHelper.o(itemData)) || i == 1) {
            this.h.setVisibility(0);
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            TiePlusHelper tiePlusHelper = this.i;
            tiePlusHelper.D(itemData.appId);
            tiePlusHelper.J(itemData.buttonLink);
            tiePlusHelper.M(itemData.pkgName);
            TiePlusHelper tiePlusHelper2 = this.i;
            tiePlusHelper2.Y(tiePlusHelper2.s(), this.i.p(), getContext(), this.h);
            this.i.L(itemData);
        } else {
            this.B = false;
            this.f.setVisibility(8);
            this.h.setVisibility(8);
            if (this.A) {
                u45 u45Var = new u45(itemData, this.E, "");
                ItemCardHelper.n(this.g, u45Var);
                itemData = u45Var.a();
                this.g.setText(itemData.buttonName);
                this.g.k();
            }
            setIsShowRightBtn(this.A);
        }
        setMaxLinesByItemButtonName(itemData.buttonName);
    }

    public void setData(ItemData itemData, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048596, this, new Object[]{itemData, Integer.valueOf(i), str, Boolean.valueOf(z)}) != null) || itemData == null) {
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
        this.b.setText(A(this.j));
        this.a.K(itemData.mIconUrl, i, false);
        setTag(itemData.mTags);
        L();
        if (z) {
            J(itemData, str);
        }
        I(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{itemData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.g.getStyleConfig();
        if (styleConfig instanceof o45) {
            ((o45) styleConfig).q(R.color.CAM_X0304);
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
        this.f.setClickCallback(new c(this, i2, i3, itemData));
        this.f.setCustomColorBtn(SkinManager.getColor(R.color.CAM_X0303), false);
        this.f.setUserProgressTextGradientModel(true);
        n45 n45Var = new n45();
        n45Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
        this.g.setConfig(n45Var);
        this.b.setText(A(this.j));
        this.a.K(itemData.mIconUrl, i, false);
        setTag(itemData.mTags);
        L();
        J(itemData, "");
        I(itemData.mIconSize);
    }

    public void setData(ItemData itemData, int i, boolean z, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048598, this, new Object[]{itemData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || itemData == null) {
            return;
        }
        TBSpecificationButtonConfig styleConfig = this.g.getStyleConfig();
        if (styleConfig instanceof o45) {
            ((o45) styleConfig).q(R.color.CAM_X0304);
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
        n45 n45Var = new n45();
        n45Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
        this.g.setConfig(n45Var);
        this.h.setOnClickListener(new d(this, i3, i4, itemData));
        this.b.setText(A(this.j));
        this.a.K(itemData.mIconUrl, i, false);
        setTag(itemData.mTags);
        L();
        M(itemData, i2);
        I(itemData.mIconSize);
    }
}
