package c.a.p0.q4;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class i implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Spannable a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.e1.n.f f17737b;

    /* renamed from: c  reason: collision with root package name */
    public int f17738c;

    public i(Spannable spannable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spannable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17737b = null;
        this.f17738c = 0;
        this.a = spannable;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f17738c = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        c.a.o0.e1.n.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (action == 3 && (fVar = this.f17737b) != null) {
                    fVar.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                    this.f17737b = null;
                    return false;
                }
                if (action == 1 || action == 0) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    Layout layout = textView.getLayout();
                    if (layout == null) {
                        return false;
                    }
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - textView.getTotalPaddingTop()) + textView.getScrollY()), (x - textView.getTotalPaddingLeft()) + textView.getScrollX());
                    Spannable spannable = this.a;
                    if (spannable == null) {
                        return false;
                    }
                    c.a.o0.e1.n.f[] fVarArr = (c.a.o0.e1.n.f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, c.a.o0.e1.n.f.class);
                    if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                        if (action == 1) {
                            fVarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                            fVarArr[0].onClick(textView);
                            view.invalidate();
                        } else {
                            c.a.o0.e1.n.f fVar2 = fVarArr[0];
                            this.f17737b = fVar2;
                            if (fVar2.e()) {
                                int i = this.f17738c;
                                if (i != 0) {
                                    fVarArr[0].g(SkinManager.getColor(i));
                                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    fVarArr[0].g(SkinManager.getColor(R.color.CAM_X0204));
                                } else {
                                    fVarArr[0].g(SkinManager.getColor(R.color.cp_bg_line_z));
                                }
                            }
                            Spannable spannable2 = this.a;
                            Selection.setSelection(spannable2, spannable2.getSpanStart(fVarArr[0]), this.a.getSpanEnd(fVarArr[0]));
                            view.invalidate();
                        }
                        return true;
                    }
                    c.a.o0.e1.n.f fVar3 = this.f17737b;
                    if (fVar3 != null) {
                        fVar3.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        view.invalidate();
                    }
                    Selection.removeSelection(this.a);
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
