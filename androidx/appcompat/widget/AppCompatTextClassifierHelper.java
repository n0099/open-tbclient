package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class AppCompatTextClassifierHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public TextClassifier mTextClassifier;
    @NonNull
    public TextView mTextView;

    public AppCompatTextClassifierHelper(@NonNull TextView textView) {
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
        this.mTextView = (TextView) Preconditions.checkNotNull(textView);
    }

    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TextClassifier textClassifier = this.mTextClassifier;
            if (textClassifier == null) {
                TextClassificationManager textClassificationManager = (TextClassificationManager) this.mTextView.getContext().getSystemService(TextClassificationManager.class);
                if (textClassificationManager != null) {
                    return textClassificationManager.getTextClassifier();
                }
                return TextClassifier.NO_OP;
            }
            return textClassifier;
        }
        return (TextClassifier) invokeV.objValue;
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textClassifier) == null) {
            this.mTextClassifier = textClassifier;
        }
    }
}
