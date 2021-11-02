package com.baidu.searchbox.ui;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CustomLinkByEllipsize implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int maxLines;
    public TextView textView;

    public CustomLinkByEllipsize(TextView textView) {
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
        this.maxLines = maxLines;
        if (maxLines <= 0) {
            this.maxLines = 1;
        }
        this.textView = textView;
        textView.setMaxLines(this.maxLines + 1);
        this.textView.setSingleLine(false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        CharSequence text;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.textView.getLineCount() <= this.maxLines) {
            return;
        }
        try {
            text = this.textView.getText().subSequence(0, this.textView.getLayout().getLineEnd(this.maxLines - 1) - 2);
            str = "...";
        } catch (Exception unused) {
            text = this.textView.getText();
            str = "";
        }
        TextUtils.TruncateAt ellipsize = this.textView.getEllipsize();
        if (ellipsize == TextUtils.TruncateAt.START) {
            this.textView.setText(str);
            this.textView.append(text);
        } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
            this.textView.setText(text.subSequence(0, text.length() / 2));
            this.textView.append(str);
            this.textView.append(text.subSequence(text.length() / 2, text.length()));
        } else {
            this.textView.setText(text);
            this.textView.append(str);
        }
    }
}
