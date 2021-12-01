package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class InputConnectionCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    public static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    public static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    public static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    public static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    public static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    public static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    public static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    public static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    public static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    public static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    public static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    public static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle);
    }

    @Deprecated
    public InputConnectionCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i2, @Nullable Bundle bundle) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{inputConnection, editorInfo, inputContentInfoCompat, Integer.valueOf(i2), bundle})) == null) {
            ClipDescription description = inputContentInfoCompat.getDescription();
            String[] contentMimeTypes = EditorInfoCompat.getContentMimeTypes(editorInfo);
            int length = contentMimeTypes.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                } else if (description.hasMimeType(contentMimeTypes[i3])) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                if (Build.VERSION.SDK_INT >= 25) {
                    return inputConnection.commitContent((InputContentInfo) inputContentInfoCompat.unwrap(), i2, bundle);
                }
                int protocol = EditorInfoCompat.getProtocol(editorInfo);
                if (protocol == 2) {
                    z2 = true;
                } else if (protocol != 3 && protocol != 4) {
                    return false;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(z2 ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY, inputContentInfoCompat.getContentUri());
                bundle2.putParcelable(z2 ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY, inputContentInfoCompat.getDescription());
                bundle2.putParcelable(z2 ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY, inputContentInfoCompat.getLinkUri());
                bundle2.putInt(z2 ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY, i2);
                bundle2.putParcelable(z2 ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY, bundle);
                return inputConnection.performPrivateCommand(z2 ? COMMIT_CONTENT_INTEROP_ACTION : COMMIT_CONTENT_ACTION, bundle2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull OnCommitContentListener onCommitContentListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, inputConnection, editorInfo, onCommitContentListener)) == null) {
            if (inputConnection != null) {
                if (editorInfo != null) {
                    if (onCommitContentListener != null) {
                        if (Build.VERSION.SDK_INT >= 25) {
                            return new InputConnectionWrapper(inputConnection, false, onCommitContentListener) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ OnCommitContentListener val$listener;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(inputConnection, r9);
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {inputConnection, Boolean.valueOf(r9), onCommitContentListener};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            Object[] objArr2 = newInitContext.callArgs;
                                            super((InputConnection) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$listener = onCommitContentListener;
                                }

                                @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                                public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
                                    InterceptResult invokeLIL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, inputContentInfo, i2, bundle)) == null) {
                                        if (this.val$listener.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i2, bundle)) {
                                            return true;
                                        }
                                        return super.commitContent(inputContentInfo, i2, bundle);
                                    }
                                    return invokeLIL.booleanValue;
                                }
                            };
                        }
                        return EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0 ? inputConnection : new InputConnectionWrapper(inputConnection, false, onCommitContentListener) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ OnCommitContentListener val$listener;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(inputConnection, r9);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {inputConnection, Boolean.valueOf(r9), onCommitContentListener};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((InputConnection) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$listener = onCommitContentListener;
                            }

                            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                            public boolean performPrivateCommand(String str, Bundle bundle) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, bundle)) == null) {
                                    if (InputConnectionCompat.handlePerformPrivateCommand(str, bundle, this.val$listener)) {
                                        return true;
                                    }
                                    return super.performPrivateCommand(str, bundle);
                                }
                                return invokeLL.booleanValue;
                            }
                        };
                    }
                    throw new IllegalArgumentException("onCommitContentListener must be non-null");
                }
                throw new IllegalArgumentException("editorInfo must be non-null");
            }
            throw new IllegalArgumentException("inputConnection must be non-null");
        }
        return (InputConnection) invokeLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x007b */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: android.os.ResultReceiver */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: android.os.ResultReceiver */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: android.os.ResultReceiver */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static boolean handlePerformPrivateCommand(@Nullable String str, @NonNull Bundle bundle, @NonNull OnCommitContentListener onCommitContentListener) {
        InterceptResult invokeLLL;
        boolean z;
        ResultReceiver resultReceiver;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65539, null, str, bundle, onCommitContentListener)) != null) {
            return invokeLLL.booleanValue;
        }
        ?? r0 = 0;
        r0 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, str)) {
            z = false;
        } else if (!TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, str)) {
            return false;
        } else {
            z = true;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(z ? COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY : COMMIT_CONTENT_RESULT_RECEIVER_KEY);
            try {
                Uri uri = (Uri) bundle.getParcelable(z ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY);
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY);
                Uri uri2 = (Uri) bundle.getParcelable(z ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY);
                int i2 = bundle.getInt(z ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY);
                Bundle bundle2 = (Bundle) bundle.getParcelable(z ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY);
                if (uri != null && clipDescription != null) {
                    r0 = onCommitContentListener.onCommitContent(new InputContentInfoCompat(uri, clipDescription, uri2), i2, bundle2);
                }
                if (resultReceiver != 0) {
                    resultReceiver.send(r0, null);
                }
                return r0;
            } catch (Throwable th) {
                th = th;
                if (resultReceiver != 0) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            resultReceiver = 0;
        }
    }
}
