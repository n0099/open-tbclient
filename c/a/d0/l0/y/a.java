package c.a.d0.l0.y;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f3045e;

    /* renamed from: f  reason: collision with root package name */
    public int f3046f;

    public a(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int maxLines = textView.getMaxLines();
        this.f3046f = maxLines;
        if (maxLines <= 0) {
            this.f3046f = 1;
        }
        this.f3045e = textView;
        textView.setMaxLines(this.f3046f + 1);
        this.f3045e.setSingleLine(false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        CharSequence text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            if (this.f3045e.getLineCount() > this.f3046f) {
                try {
                    text = this.f3045e.getText().subSequence(0, this.f3045e.getLayout().getLineEnd(this.f3046f - 1) - 2);
                    str = "...";
                } catch (Exception e2) {
                    c.a.d0.i.a.d("CustomLinkByEllipsize", "", e2);
                    text = this.f3045e.getText();
                }
                TextUtils.TruncateAt ellipsize = this.f3045e.getEllipsize();
                if (ellipsize == TextUtils.TruncateAt.START) {
                    this.f3045e.setText(str);
                    this.f3045e.append(text);
                } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
                    this.f3045e.setText(text.subSequence(0, text.length() / 2));
                    this.f3045e.append(str);
                    this.f3045e.append(text.subSequence(text.length() / 2, text.length()));
                } else {
                    this.f3045e.setText(text);
                    this.f3045e.append(str);
                }
            }
        }
    }
}
