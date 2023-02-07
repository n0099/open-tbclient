package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "ReceiveContent";
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static final class Api16Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api16Impl() {
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

        public static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, item, i)) == null) {
                if ((i & 1) != 0) {
                    CharSequence coerceToText = item.coerceToText(context);
                    if (coerceToText instanceof Spanned) {
                        return coerceToText.toString();
                    }
                    return coerceToText;
                }
                return item.coerceToStyledText(context);
            }
            return (CharSequence) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class ApiImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ApiImpl() {
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

        public static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, item, i)) == null) {
                CharSequence coerceToText = item.coerceToText(context);
                if ((i & 1) != 0 && (coerceToText instanceof Spanned)) {
                    return coerceToText.toString();
                }
                return coerceToText;
            }
            return (CharSequence) invokeLLI.objValue;
        }
    }

    public TextViewOnReceiveContentListener() {
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

    public static CharSequence coerceToText(@NonNull Context context, @NonNull ClipData.Item item, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, item, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return Api16Impl.coerce(context, item, i);
            }
            return ApiImpl.coerce(context, item, i);
        }
        return (CharSequence) invokeLLI.objValue;
    }

    public static void replaceSelection(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, editable, charSequence) == null) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            int max = Math.max(0, Math.min(selectionStart, selectionEnd));
            int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
            Selection.setSelection(editable, max2);
            editable.replace(max, max2, charSequence);
        }
    }

    @Override // androidx.core.view.OnReceiveContentListener
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View view2, @NonNull ContentInfoCompat contentInfoCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, contentInfoCompat)) == null) {
            if (Log.isLoggable(LOG_TAG, 3)) {
                Log.d(LOG_TAG, "onReceive: " + contentInfoCompat);
            }
            if (contentInfoCompat.getSource() == 2) {
                return contentInfoCompat;
            }
            ClipData clip = contentInfoCompat.getClip();
            int flags = contentInfoCompat.getFlags();
            TextView textView = (TextView) view2;
            Editable editable = (Editable) textView.getText();
            Context context = textView.getContext();
            boolean z = false;
            for (int i = 0; i < clip.getItemCount(); i++) {
                CharSequence coerceToText = coerceToText(context, clip.getItemAt(i), flags);
                if (coerceToText != null) {
                    if (!z) {
                        replaceSelection(editable, coerceToText);
                        z = true;
                    } else {
                        editable.insert(Selection.getSelectionEnd(editable), "\n");
                        editable.insert(Selection.getSelectionEnd(editable), coerceToText);
                    }
                }
            }
            return null;
        }
        return (ContentInfoCompat) invokeLL.objValue;
    }
}
