package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RecordVideoActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENTRANCE_FLAG = "entrance_flag";
    public static final String FORUM_WRITE_DATA = "forum_write_data";
    public static final String SHOW_TYPE = "show_type";
    public static final int SHOW_TYPE_PIC_ONLY = 1;
    public static final int SHOW_TYPE_TRY_BOTH = 0;
    public static final int SHOW_TYPE_VIDEO_ONLY = 2;
    public static final String VIDEO_TITLE = "video_title";
    public static final String WRITE_IMAGE_INFO = "write_image_info";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public ForumWriteData b;
        public WriteImagesInfo c;
        public String d;
        public int e;
        public boolean f;
        public int g;
        public boolean h;
        public AntiData i;
        public PostPrefixData j;
        public String k;
        public String l;
        public boolean m;
        public Intent n;

        public b(int i, ForumWriteData forumWriteData, WriteImagesInfo writeImagesInfo, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), forumWriteData, writeImagesInfo, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = forumWriteData;
            this.c = writeImagesInfo;
            this.d = str;
            this.e = i2;
        }

        public RecordVideoActivityConfig a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(context, this.a, this.b, this.c, this.d, this.e, null);
                if (this.f) {
                    recordVideoActivityConfig.setShowType(this.g);
                }
                if (this.h) {
                    recordVideoActivityConfig.setExtraData(this.i, this.j, this.k, this.l);
                }
                if (this.m) {
                    recordVideoActivityConfig.getIntent().putExtras(this.n);
                }
                return recordVideoActivityConfig;
            }
            return (RecordVideoActivityConfig) invokeL.objValue;
        }

        public void b(Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
                this.m = true;
                this.n = intent;
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.f = true;
                this.g = i;
            }
        }

        public void c(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, antiData, postPrefixData, str, str2) == null) {
                this.h = true;
                this.i = antiData;
                this.j = postPrefixData;
                this.k = str;
                this.l = str2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordVideoActivityConfig(@NonNull Context context, int i, ForumWriteData forumWriteData, WriteImagesInfo writeImagesInfo, String str, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), forumWriteData, writeImagesInfo, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(FORUM_WRITE_DATA, forumWriteData);
        getIntent().putExtra(WRITE_IMAGE_INFO, writeImagesInfo);
        getIntent().putExtra("video_title", str);
        getIntent().putExtra(ENTRANCE_FLAG, i);
        getIntent().putExtra("from_type", i2);
        setRequestCode(13010);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public /* synthetic */ RecordVideoActivityConfig(Context context, int i, ForumWriteData forumWriteData, WriteImagesInfo writeImagesInfo, String str, int i2, a aVar) {
        this(context, i, forumWriteData, writeImagesInfo, str, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, antiData, postPrefixData, str, str2) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            getIntent().putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
            getIntent().putExtra(BaseWriteConfig.PREFIX_DATA, postPrefixData);
            getIntent().putExtra("anti_data", antiData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65541, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(SHOW_TYPE, i);
        }
    }
}
