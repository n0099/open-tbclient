package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class EditHeadActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCOUNTDATA = "account_data";
    public static String ACTION_UPLOAD_SUCCESS = "upload.image.success";
    public static final int ALA_PERSON_TYPE = 3;
    public static final int CHANNEL_AVATAR = 4;
    public static final int CHANNEL_COVER = 5;
    public static final String CUT_IMAGE_HEIGHT_SCALE = "cut_image_height_scale";
    public static final String EDITTYPE = "edit_type";
    public static String FILE_NAME = "file_name";
    public static final String FROMCODE = "request";
    public static final String FROM_ALA_LIVE_COVER_CUT = "fom_ala_live_cover";
    public static final String FROM_FLUTTER_IMAGEPICKER = "from_flutter_imagepicker";
    public static final String FROM_MISSON_SET_COVER = "from_misson_set_cover";
    public static final String FROM_PHOTO_LIVE = "from_photo_live";
    public static final String FROM_WHERE = "from_where";
    public static final int GROUP_PHOTO_WALL = 2;
    public static final int GROUP_TYPE = 1;
    public static final String NEED_PASTE = "need_paste";
    public static final String NEED_UPLOAD = "need_upload";
    public static final int PERSON_TYPE = 0;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static final String UPLOAD_IMAGE_TYPE = "upload_image_type";
    public static final int UPLOAD_TYPE_NO = 0;
    public static final int UPLOAD_TYPE_RESET_PORTRAIT = 1;
    public static final int UPLOAD_TYPE_UPLOAD_ONLY = 2;
    public static final String WATERMARK_TYPE = "watermark_type";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-844597511, "Lcom/baidu/tbadk/core/atomData/EditHeadActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-844597511, "Lcom/baidu/tbadk/core/atomData/EditHeadActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadActivityConfig(Context context, int i2, int i3, Uri uri, AccountData accountData, int i4, String str, float f2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4), str, Float.valueOf(f2)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        getIntent().putExtra("request", i2);
        getIntent().putExtra("account_data", accountData);
        getIntent().putExtra("edit_type", i4);
        getIntent().putExtra(FILE_NAME, str);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f2);
        getIntent().setData(uri);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig setFromWhere(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!StringUtils.isNull(str)) {
                getIntent().putExtra(FROM_WHERE, str);
            }
            return this;
        }
        return (EditHeadActivityConfig) invokeL.objValue;
    }

    public EditHeadActivityConfig setNeedPaste(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            getIntent().putExtra(NEED_PASTE, z);
            return this;
        }
        return (EditHeadActivityConfig) invokeZ.objValue;
    }

    public EditHeadActivityConfig setWaterMaskType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            getIntent().putExtra(WATERMARK_TYPE, i2);
            return this;
        }
        return (EditHeadActivityConfig) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadActivityConfig(Context context, int i2, int i3, Uri uri, AccountData accountData, int i4, String str, float f2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4), str, Float.valueOf(f2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        getIntent().putExtra("request", i2);
        getIntent().putExtra("account_data", accountData);
        getIntent().putExtra("edit_type", i4);
        getIntent().putExtra(FILE_NAME, str);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f2);
        getIntent().putExtra("need_upload", z);
        getIntent().setData(uri);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadActivityConfig(Context context, int i2, int i3, Uri uri, AccountData accountData, int i4, float f2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4), Float.valueOf(f2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("request", i2);
        getIntent().putExtra("account_data", accountData);
        getIntent().putExtra("edit_type", i4);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f2);
        getIntent().setData(uri);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadActivityConfig(Context context, int i2, int i3, Uri uri, AccountData accountData, float f2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("request", i2);
        getIntent().putExtra("account_data", accountData);
        getIntent().putExtra("edit_type", 0);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f2);
        getIntent().setData(uri);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadActivityConfig(Context context, int i2, int i3, Uri uri, AccountData accountData, float f2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Float.valueOf(f2), Boolean.valueOf(z)};
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
        getIntent().putExtra("request", i2);
        getIntent().putExtra("account_data", accountData);
        getIntent().putExtra("edit_type", 0);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f2);
        getIntent().putExtra("need_upload", z);
        getIntent().setData(uri);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadActivityConfig(Context context, int i2, int i3, Uri uri, AccountData accountData, int i4, float f2, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4), Float.valueOf(f2), str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra("request", i2);
        getIntent().putExtra("account_data", accountData);
        getIntent().putExtra("edit_type", i4);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f2);
        getIntent().putExtra(FROM_WHERE, str);
        getIntent().setData(uri);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadActivityConfig(Context context, int i2, int i3, Uri uri, AccountData accountData, int i4, String str, float f2, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4), str, Float.valueOf(f2), str2};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        getIntent().putExtra("request", i2);
        getIntent().putExtra("account_data", accountData);
        getIntent().putExtra("edit_type", i4);
        getIntent().putExtra(FILE_NAME, str);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f2);
        getIntent().putExtra(FROM_WHERE, str2);
        getIntent().setData(uri);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
