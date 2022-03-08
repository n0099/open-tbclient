package c.a.b0.l0.q;

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
    public TextView f1860e;

    /* renamed from: f  reason: collision with root package name */
    public int f1861f;

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
        this.f1861f = maxLines;
        if (maxLines <= 0) {
            this.f1861f = 1;
        }
        this.f1860e = textView;
        textView.setMaxLines(this.f1861f + 1);
        this.f1860e.setSingleLine(false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        CharSequence text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            if (this.f1860e.getLineCount() > this.f1861f) {
                try {
                    text = this.f1860e.getText().subSequence(0, this.f1860e.getLayout().getLineEnd(this.f1861f - 1) - 2);
                    str = "...";
                } catch (Exception e2) {
                    c.a.b0.i.a.d("CustomLinkByEllipsize", "", e2);
                    text = this.f1860e.getText();
                }
                TextUtils.TruncateAt ellipsize = this.f1860e.getEllipsize();
                if (ellipsize == TextUtils.TruncateAt.START) {
                    this.f1860e.setText(str);
                    this.f1860e.append(text);
                } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
                    this.f1860e.setText(text.subSequence(0, text.length() / 2));
                    this.f1860e.append(str);
                    this.f1860e.append(text.subSequence(text.length() / 2, text.length()));
                } else {
                    this.f1860e.setText(text);
                    this.f1860e.append(str);
                }
            }
        }
    }
}
