package c.a.c0.h0.d0;

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
    public TextView f2132e;

    /* renamed from: f  reason: collision with root package name */
    public int f2133f;

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
        this.f2133f = maxLines;
        if (maxLines <= 0) {
            this.f2133f = 1;
        }
        this.f2132e = textView;
        textView.setMaxLines(this.f2133f + 1);
        this.f2132e.setSingleLine(false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        CharSequence text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            if (this.f2132e.getLineCount() > this.f2133f) {
                try {
                    text = this.f2132e.getText().subSequence(0, this.f2132e.getLayout().getLineEnd(this.f2133f - 1) - 2);
                    str = "...";
                } catch (Exception e2) {
                    c.a.c0.f.a.d("CustomLinkByEllipsize", "", e2);
                    text = this.f2132e.getText();
                }
                TextUtils.TruncateAt ellipsize = this.f2132e.getEllipsize();
                if (ellipsize == TextUtils.TruncateAt.START) {
                    this.f2132e.setText(str);
                    this.f2132e.append(text);
                } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
                    this.f2132e.setText(text.subSequence(0, text.length() / 2));
                    this.f2132e.append(str);
                    this.f2132e.append(text.subSequence(text.length() / 2, text.length()));
                } else {
                    this.f2132e.setText(text);
                    this.f2132e.append(str);
                }
            }
        }
    }
}
