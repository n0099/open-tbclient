package c.a.a0.l0.s;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f1489b;

    public a(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int maxLines = textView.getMaxLines();
        this.f1489b = maxLines;
        if (maxLines <= 0) {
            this.f1489b = 1;
        }
        this.a = textView;
        textView.setMaxLines(this.f1489b + 1);
        this.a.setSingleLine(false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        CharSequence text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            if (this.a.getLineCount() > this.f1489b) {
                try {
                    text = this.a.getText().subSequence(0, this.a.getLayout().getLineEnd(this.f1489b - 1) - 2);
                    str = StringHelper.STRING_MORE;
                } catch (Exception e2) {
                    c.a.a0.i.a.d("CustomLinkByEllipsize", "", e2);
                    text = this.a.getText();
                }
                TextUtils.TruncateAt ellipsize = this.a.getEllipsize();
                if (ellipsize == TextUtils.TruncateAt.START) {
                    this.a.setText(str);
                    this.a.append(text);
                } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
                    this.a.setText(text.subSequence(0, text.length() / 2));
                    this.a.append(str);
                    this.a.append(text.subSequence(text.length() / 2, text.length()));
                } else {
                    this.a.setText(text);
                    this.a.append(str);
                }
            }
        }
    }
}
