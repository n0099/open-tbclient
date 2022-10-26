package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class WriteImageActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CANCEL_TEXT = "cancel_text";
    public static final String DELET_FLAG = "delete";
    public static final String DISPLAY_SIZE = "display_size";
    public static final String FILE_NAME = "file_name";
    public static final String FILTER_NAME_NORMAL = "normal";
    public static final String FINISH_TEXT = "finish_text";
    public static final String FORUMID = "forumid";
    public static final String FORUMNAME = "foruimname";
    public static final String FROM = "from";
    public static final String FROMCODE = "request";
    public static final String THREADID = "threadid";
    public static boolean isActivityInStack;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1237149497, "Lcom/baidu/tbadk/core/atomData/WriteImageActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1237149497, "Lcom/baidu/tbadk/core/atomData/WriteImageActivityConfig;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WriteImageActivityConfig(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        this(context, i, i2, uri, str, str2, antiData, 0, null, null, "frs");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), uri, str, str2, antiData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (Uri) objArr2[3], (String) objArr2[4], (String) objArr2[5], (AntiData) objArr2[6], ((Integer) objArr2[7]).intValue(), (String) objArr2[8], (String) objArr2[9], (String) objArr2[10]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteImageActivityConfig(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4, String str5) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), uri, str, str2, antiData, Integer.valueOf(i3), str3, str4, str5};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("request", i);
        getIntent().putExtra("from", str5);
        getIntent().putExtra("forumid", str);
        getIntent().putExtra(FORUMNAME, str2);
        getIntent().putExtra("display_size", i3);
        if (str3 != null) {
            getIntent().putExtra(FINISH_TEXT, str3);
        }
        if (str4 != null) {
            getIntent().putExtra(CANCEL_TEXT, str4);
        }
        getIntent().setData(uri);
        setRequestCode(i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteImageActivityConfig(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4, String str5, String str6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), uri, str, str2, antiData, Integer.valueOf(i3), str3, str4, str5, str6};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("request", i);
        getIntent().putExtra("from", str5);
        getIntent().putExtra("forumid", str);
        getIntent().putExtra(FORUMNAME, str2);
        getIntent().putExtra("display_size", i3);
        if (str3 != null) {
            getIntent().putExtra(FINISH_TEXT, str3);
        }
        if (str4 != null) {
            getIntent().putExtra(CANCEL_TEXT, str4);
        }
        if (str6 != null) {
            getIntent().putExtra("file_name", str6);
        }
        getIntent().setData(uri);
        setRequestCode(i2);
    }
}
