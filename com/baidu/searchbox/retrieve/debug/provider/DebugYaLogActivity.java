package com.baidu.searchbox.retrieve.debug.provider;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tieba.R;
import com.baidu.tieba.pz9;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.xz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.LoggerManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DebugYaLogActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Button mBtnActiveReUpload;
    public Button mBtnActiveSnapReUpload;
    public Button mBtnActiveSnapUpload;
    public Button mBtnActiveUpload;
    public Button mBtnCleanLog;
    public Button mBtnGetCuid;
    public Button mBtnLogFlush;
    public Button mBtnQueryFile;
    public Button mBtnSave10ThousandLog;
    public Button mBtnSaveConfig;
    public Button mBtnSaveIdConfig;
    public Button mBtnSaveOneLog;
    public Button mBtnSaveThousandLog;
    public Button mBtnVoyagerSaveConfig;
    public CheckBox mCheckClear;
    public CheckBox mCheckIdSwitch1;
    public CheckBox mCheckIdSwitch2;
    public CheckBox mCheckIdSwitch3;
    public CheckBox mCheckLogFlushWait;
    public CheckBox mCheckSpaceSwitch1;
    public CheckBox mCheckSpaceSwitch2;
    public CheckBox mCheckSpaceSwitch3;
    public CheckBox mCheckSwitchBiz1;
    public CheckBox mCheckSwitchBiz2;
    public CheckBox mCheckTotalSwitch;
    public CheckBox mCheckVoyagerClear;
    public CheckBox mCheckVoyagerSwitch;
    public EditText mEditBizExpiredTime1;
    public EditText mEditBizExpiredTime2;
    public EditText mEditBizMaxCount1;
    public EditText mEditBizMaxCount2;
    public EditText mEditBizMaxSize1;
    public EditText mEditBizMaxSize2;
    public EditText mEditBizNetType1;
    public EditText mEditBizNetType2;
    public EditText mEditBizType1;
    public EditText mEditBizType2;
    public EditText mEditExpiredTime;
    public EditText mEditHistoryDelCount;
    public EditText mEditHistoryExpiredTime;
    public EditText mEditHistoryMaxCount;
    public EditText mEditIdName1;
    public EditText mEditIdName2;
    public EditText mEditIdName3;
    public EditText mEditIdSize;
    public EditText mEditIdSize1;
    public EditText mEditIdSize2;
    public EditText mEditIdSize3;
    public EditText mEditLogContent;
    public EditText mEditLogSpace;
    public EditText mEditSingleMaxCount;
    public EditText mEditSingleMaxSize;
    public EditText mEditSingleSize;
    public EditText mEditSpace1;
    public EditText mEditSpace2;
    public EditText mEditSpace3;
    public EditText mEditSpaceSize;
    public EditText mEditSpaceSize1;
    public EditText mEditSpaceSize2;
    public EditText mEditSpaceSize3;
    public EditText mEditSpaceTime1;
    public EditText mEditSpaceTime2;
    public EditText mEditSpaceTime3;
    public EditText mEditSpaceTimeout;
    public EditText mEditTotalMaxCount;
    public EditText mEditTotalMaxSize;
    public EditText mEditTotalSize;
    public EditText mEditUploadEndTime;
    public EditText mEditUploadId;
    public EditText mEditUploadMaxCount;
    public EditText mEditUploadMaxSize;
    public EditText mEditUploadSpace;
    public EditText mEditUploadStartTime;
    public EditText mEditUploadType;
    public EditText mEditVoyagerUploadInterval;
    public TextView mTextClearIntro;
    public TextView mTextLogFlushIntro;
    public TextView mTextQueryResult;
    public TextView mTextRetrievePlat;
    public TextView mTextSwitchIntro;
    public TextView mVoyagerClearIntro;
    public TextView mVoyagerSwitchIntro;

    /* renamed from: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity$15  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass15 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DebugYaLogActivity this$0;

        public AnonymousClass15(DebugYaLogActivity debugYaLogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {debugYaLogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = debugYaLogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = ((Object) this.this$0.mEditUploadType.getText()) + "";
                if (TextUtils.isEmpty(str)) {
                    str = ((Object) this.this$0.mEditUploadType.getHint()) + "";
                }
                String str2 = str;
                String str3 = ((Object) this.this$0.mEditUploadId.getText()) + "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = ((Object) this.this$0.mEditUploadId.getHint()) + "";
                }
                String str4 = str3;
                List<String> asList = Arrays.asList((((Object) this.this$0.mEditUploadSpace.getText()) + "").split(","));
                if (asList.size() == 0) {
                    asList.add(((Object) this.this$0.mEditUploadSpace.getHint()) + "");
                }
                long j3 = 0;
                try {
                    j = Long.parseLong(((Object) this.this$0.mEditUploadMaxSize.getText()) + "");
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                try {
                    j3 = Long.parseLong(((Object) this.this$0.mEditUploadStartTime.getText()) + "");
                } catch (NumberFormatException unused2) {
                }
                long j4 = j3;
                try {
                    j2 = Long.parseLong(((Object) this.this$0.mEditUploadEndTime.getText()) + "");
                } catch (NumberFormatException unused3) {
                    j2 = 1;
                }
                ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUpload(str2, str4, asList, j, j4, System.currentTimeMillis() + (j2 * 1000), new IActiveUploadListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.15.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass15 this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                    public void onFailure(String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this, str5) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.15.1.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$2;
                                public final /* synthetic */ String val$reason;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, str5};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$2 = this;
                                    this.val$reason = str5;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        DebugYaLogActivity debugYaLogActivity = this.this$2.this$1.this$0;
                                        Toast.makeText(debugYaLogActivity, "主动上传失败, 原因: " + this.val$reason, 1).show();
                                    }
                                }
                            });
                        }
                    }

                    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                    public void onSuccess() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.15.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$2;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$2 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Toast.makeText(this.this$2.this$1.this$0, "主动上传成功", 1).show();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity$17  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass17 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DebugYaLogActivity this$0;

        public AnonymousClass17(DebugYaLogActivity debugYaLogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {debugYaLogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = debugYaLogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = ((Object) this.this$0.mEditUploadType.getText()) + "";
                if (TextUtils.isEmpty(str)) {
                    str = ((Object) this.this$0.mEditUploadType.getHint()) + "";
                }
                String str2 = str;
                String str3 = ((Object) this.this$0.mEditUploadId.getText()) + "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = ((Object) this.this$0.mEditUploadId.getHint()) + "";
                }
                String str4 = str3;
                List<String> asList = Arrays.asList((((Object) this.this$0.mEditUploadSpace.getText()) + "").split(","));
                if (asList.size() == 0) {
                    asList.add(((Object) this.this$0.mEditUploadSpace.getHint()) + "");
                }
                long j3 = 0;
                try {
                    j = Long.parseLong(((Object) this.this$0.mEditUploadMaxSize.getText()) + "");
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                try {
                    j3 = Long.parseLong(((Object) this.this$0.mEditUploadStartTime.getText()) + "");
                } catch (NumberFormatException unused2) {
                }
                long j4 = j3;
                try {
                    j2 = Long.parseLong(((Object) this.this$0.mEditUploadEndTime.getText()) + "");
                } catch (NumberFormatException unused3) {
                    j2 = 1;
                }
                ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUploadSnapShot(str2, str4, asList, j, j4, System.currentTimeMillis() + (j2 * 1000), true, new IActiveUploadListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.17.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass17 this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                    public void onFailure(String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this, str5) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.17.1.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$2;
                                public final /* synthetic */ String val$reason;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, str5};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$2 = this;
                                    this.val$reason = str5;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        DebugYaLogActivity debugYaLogActivity = this.this$2.this$1.this$0;
                                        Toast.makeText(debugYaLogActivity, "主动上传失败, 原因: " + this.val$reason, 1).show();
                                    }
                                }
                            });
                        }
                    }

                    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                    public void onSuccess() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.17.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$2;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$2 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Toast.makeText(this.this$2.this$1.this$0, "主动上传成功", 1).show();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public DebugYaLogActivity() {
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

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.debug_yalog_activity);
            initView();
            initListener();
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mCheckTotalSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                        if (z) {
                            this.this$0.mTextSwitchIntro.setText(R.string.tv_switch_on_intro);
                        } else {
                            this.this$0.mTextSwitchIntro.setText(R.string.tv_switch_off_intro);
                        }
                    }
                }
            });
            this.mCheckClear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                        if (z) {
                            this.this$0.mTextClearIntro.setText(R.string.tv_clear_on_intro);
                        } else {
                            this.this$0.mTextClearIntro.setText(R.string.tv_clear_off_intro);
                        }
                    }
                }
            });
            this.mBtnSaveOneLog.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.this$0.writeLog(1);
                }
            });
            this.mBtnSaveThousandLog.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.this$0.writeLog(1000);
                }
            });
            this.mBtnSave10ThousandLog.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.this$0.writeLog(10000);
                }
            });
            this.mCheckLogFlushWait.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                        if (z) {
                            this.this$0.mTextLogFlushIntro.setText(R.string.tv_flush_wait_true);
                        } else {
                            this.this$0.mTextLogFlushIntro.setText(R.string.tv_flush_wait_false);
                        }
                    }
                }
            });
            this.mBtnLogFlush.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        String str = ((Object) this.this$0.mEditLogSpace.getText()) + "";
                        if (TextUtils.isEmpty(str)) {
                            str = "debug";
                        }
                        LoggerManager.getLogger(str).flush(this.this$0.mCheckLogFlushWait.isChecked());
                    }
                }
            });
            this.mBtnQueryFile.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        String str2 = ((Object) this.this$0.mEditLogSpace.getText()) + "";
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "*";
                        }
                        List<String> queryLogFiles = LoggerManager.queryLogFiles(0L, System.currentTimeMillis() / 1000, str2, "*");
                        if (queryLogFiles != null && queryLogFiles.size() != 0) {
                            str = Arrays.asList(queryLogFiles).toString();
                        } else {
                            str = "查询结果为空";
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, str) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.8.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass8 this$1;
                            public final /* synthetic */ String val$queryResult;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$queryResult = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.this$0.mTextQueryResult.setText(this.val$queryResult);
                                }
                            }
                        });
                    }
                }
            });
            this.mBtnCleanLog.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TextUtils.isEmpty(((Object) this.this$0.mEditLogSpace.getText()) + "");
                        LoggerManager.requestCleanOverQuotaLog();
                    }
                }
            });
            this.mBtnSaveConfig.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.this$0.saveConfig();
                }
            });
            this.mBtnSaveIdConfig.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.this$0.saveIdConfig();
                }
            });
            this.mCheckVoyagerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                        if (z) {
                            this.this$0.mVoyagerSwitchIntro.setText(R.string.tv_voyager_switch_on_intro);
                        } else {
                            this.this$0.mVoyagerSwitchIntro.setText(R.string.tv_voyager_switch_off_intro);
                        }
                    }
                }
            });
            this.mCheckVoyagerClear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                        if (z) {
                            this.this$0.mVoyagerClearIntro.setText(R.string.tv_voyager_clear_on_intro);
                        } else {
                            this.this$0.mVoyagerClearIntro.setText(R.string.tv_voyager_clear_off_intro);
                        }
                    }
                }
            });
            this.mBtnVoyagerSaveConfig.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.this$0.saveVoyagerConfig();
                }
            });
            this.mBtnActiveUpload.setOnClickListener(new AnonymousClass15(this));
            this.mBtnActiveReUpload.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    long j;
                    long j2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        String str = ((Object) this.this$0.mEditUploadType.getText()) + "";
                        if (TextUtils.isEmpty(str)) {
                            str = ((Object) this.this$0.mEditUploadType.getHint()) + "";
                        }
                        String str2 = str;
                        String str3 = ((Object) this.this$0.mEditUploadId.getText()) + "";
                        if (TextUtils.isEmpty(str3)) {
                            str3 = ((Object) this.this$0.mEditUploadId.getHint()) + "";
                        }
                        String str4 = str3;
                        List<String> asList = Arrays.asList((((Object) this.this$0.mEditUploadSpace.getText()) + "").split(","));
                        if (asList.size() == 0) {
                            asList.add(((Object) this.this$0.mEditUploadSpace.getHint()) + "");
                        }
                        long j3 = 0;
                        try {
                            j = Long.parseLong(((Object) this.this$0.mEditUploadMaxSize.getText()) + "");
                        } catch (NumberFormatException unused) {
                            j = 0;
                        }
                        try {
                            j3 = Long.parseLong(((Object) this.this$0.mEditUploadStartTime.getText()) + "");
                        } catch (NumberFormatException unused2) {
                        }
                        long j4 = j3;
                        try {
                            j2 = Long.parseLong(((Object) this.this$0.mEditUploadEndTime.getText()) + "");
                        } catch (NumberFormatException unused3) {
                            j2 = 1;
                        }
                        ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUpload(str2, str4, asList, DebugActiveUploadResult.SOURCE, j, j4, System.currentTimeMillis() + (j2 * 1000), new JSONObject());
                    }
                }
            });
            this.mBtnActiveSnapUpload.setOnClickListener(new AnonymousClass17(this));
            this.mBtnActiveSnapReUpload.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    long j;
                    long j2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        String str = ((Object) this.this$0.mEditUploadType.getText()) + "";
                        if (TextUtils.isEmpty(str)) {
                            str = ((Object) this.this$0.mEditUploadType.getHint()) + "";
                        }
                        String str2 = str;
                        String str3 = ((Object) this.this$0.mEditUploadId.getText()) + "";
                        if (TextUtils.isEmpty(str3)) {
                            str3 = ((Object) this.this$0.mEditUploadId.getHint()) + "";
                        }
                        String str4 = str3;
                        List<String> asList = Arrays.asList((((Object) this.this$0.mEditUploadSpace.getText()) + "").split(","));
                        if (asList.size() == 0) {
                            asList.add(((Object) this.this$0.mEditUploadSpace.getHint()) + "");
                        }
                        long j3 = 0;
                        try {
                            j = Long.parseLong(((Object) this.this$0.mEditUploadMaxSize.getText()) + "");
                        } catch (NumberFormatException unused) {
                            j = 0;
                        }
                        try {
                            j3 = Long.parseLong(((Object) this.this$0.mEditUploadStartTime.getText()) + "");
                        } catch (NumberFormatException unused2) {
                        }
                        long j4 = j3;
                        try {
                            j2 = Long.parseLong(((Object) this.this$0.mEditUploadEndTime.getText()) + "");
                        } catch (NumberFormatException unused3) {
                            j2 = 1;
                        }
                        ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUploadSnapShot(str2, str4, asList, DebugActiveUploadResult.SOURCE, j, j4, System.currentTimeMillis() + (j2 * 1000), true, new JSONObject());
                    }
                }
            });
            this.mBtnGetCuid.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ((ClipboardManager) this.this$0.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("cUID", "http://mcms.baidu.com/cuidhelper/"));
                        Toast.makeText(this.this$0, "内容已复制", 0).show();
                    }
                }
            });
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mCheckClear = (CheckBox) findViewById(R.id.cb_config_clear);
            TextView textView = (TextView) findViewById(R.id.tv_clear_intro);
            this.mTextClearIntro = textView;
            textView.setText(R.string.tv_clear_off_intro);
            this.mCheckTotalSwitch = (CheckBox) findViewById(R.id.cb_config_total_switch);
            TextView textView2 = (TextView) findViewById(R.id.tv_total_switch_intro);
            this.mTextSwitchIntro = textView2;
            textView2.setText(R.string.tv_switch_on_intro);
            this.mEditSingleSize = (EditText) findViewById(R.id.et_config_single_size);
            this.mEditTotalSize = (EditText) findViewById(R.id.et_config_total_size);
            this.mEditSpaceSize = (EditText) findViewById(R.id.et_config_space_size);
            this.mEditSpaceTimeout = (EditText) findViewById(R.id.et_config_space_timeout);
            this.mEditIdSize = (EditText) findViewById(R.id.et_config_id_size);
            this.mEditSpace1 = (EditText) findViewById(R.id.et_config_space1);
            this.mEditSpace2 = (EditText) findViewById(R.id.et_config_space2);
            this.mEditSpace3 = (EditText) findViewById(R.id.et_config_space3);
            this.mCheckSpaceSwitch1 = (CheckBox) findViewById(R.id.cb_config_space1);
            this.mCheckSpaceSwitch2 = (CheckBox) findViewById(R.id.cb_config_space2);
            this.mCheckSpaceSwitch3 = (CheckBox) findViewById(R.id.cb_config_space3);
            this.mEditSpaceSize1 = (EditText) findViewById(R.id.et_config_space_size1);
            this.mEditSpaceSize2 = (EditText) findViewById(R.id.et_config_space_size2);
            this.mEditSpaceSize3 = (EditText) findViewById(R.id.et_config_space_size3);
            this.mEditSpaceTime1 = (EditText) findViewById(R.id.et_config_space_time1);
            this.mEditSpaceTime2 = (EditText) findViewById(R.id.et_config_space_time2);
            this.mEditSpaceTime3 = (EditText) findViewById(R.id.et_config_space_time3);
            this.mBtnSaveConfig = (Button) findViewById(R.id.btn_save_config);
            this.mEditIdName1 = (EditText) findViewById(R.id.et_config_id1);
            this.mEditIdName2 = (EditText) findViewById(R.id.et_config_id2);
            this.mEditIdName3 = (EditText) findViewById(R.id.et_config_id3);
            this.mCheckIdSwitch1 = (CheckBox) findViewById(R.id.cb_config_id1);
            this.mCheckIdSwitch2 = (CheckBox) findViewById(R.id.cb_config_id2);
            this.mCheckIdSwitch3 = (CheckBox) findViewById(R.id.cb_config_id3);
            this.mEditIdSize1 = (EditText) findViewById(R.id.et_config_id_size1);
            this.mEditIdSize2 = (EditText) findViewById(R.id.et_config_id_size2);
            this.mEditIdSize3 = (EditText) findViewById(R.id.et_config_id_size3);
            this.mBtnSaveIdConfig = (Button) findViewById(R.id.btn_save_config_id);
            this.mEditLogContent = (EditText) findViewById(R.id.et_log_content);
            this.mEditLogSpace = (EditText) findViewById(R.id.et_log_space);
            this.mBtnSaveOneLog = (Button) findViewById(R.id.btn_save_one_log);
            this.mBtnSaveThousandLog = (Button) findViewById(R.id.btn_save_1000_log);
            this.mBtnSave10ThousandLog = (Button) findViewById(R.id.btn_save_10000_log);
            this.mBtnLogFlush = (Button) findViewById(R.id.btn_log_flush);
            this.mCheckLogFlushWait = (CheckBox) findViewById(R.id.cb_log_flush_wait);
            TextView textView3 = (TextView) findViewById(R.id.tv_log_flush_intro);
            this.mTextLogFlushIntro = textView3;
            textView3.setText(R.string.tv_flush_wait_false);
            this.mBtnQueryFile = (Button) findViewById(R.id.btn_query_files);
            this.mTextQueryResult = (TextView) findViewById(R.id.tv_log_query_result);
            this.mBtnCleanLog = (Button) findViewById(R.id.btn_clean_log);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("1", "a");
                jSONObject.put("2", "b");
                jSONObject.put("3", "c");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mEditLogContent.setText(jSONObject.toString());
            this.mCheckVoyagerSwitch = (CheckBox) findViewById(R.id.cb_voyager_config_total_switch);
            TextView textView4 = (TextView) findViewById(R.id.tv_voyager_total_switch_intro);
            this.mVoyagerSwitchIntro = textView4;
            textView4.setText(R.string.tv_voyager_switch_on_intro);
            this.mCheckVoyagerClear = (CheckBox) findViewById(R.id.cb_voyager_config_clear);
            TextView textView5 = (TextView) findViewById(R.id.tv_voyager_clear_intro);
            this.mVoyagerClearIntro = textView5;
            textView5.setText(R.string.tv_voyager_clear_on_intro);
            this.mEditVoyagerUploadInterval = (EditText) findViewById(R.id.et_voyager_config_upload_interval);
            this.mEditUploadMaxCount = (EditText) findViewById(R.id.et_voyager_config_count_per_round);
            this.mEditExpiredTime = (EditText) findViewById(R.id.et_voyager_config_expire_time);
            this.mEditSingleMaxCount = (EditText) findViewById(R.id.et_voyager_config_single_max_count);
            this.mEditSingleMaxSize = (EditText) findViewById(R.id.et_voyager_config_single_max_size);
            this.mEditTotalMaxCount = (EditText) findViewById(R.id.et_voyager_config_total_max_count);
            this.mEditTotalMaxSize = (EditText) findViewById(R.id.et_voyager_config_total_max_size);
            this.mEditHistoryMaxCount = (EditText) findViewById(R.id.et_voyager_config_history_max_count);
            this.mEditHistoryDelCount = (EditText) findViewById(R.id.et_voyager_config_history_del_count);
            this.mEditHistoryExpiredTime = (EditText) findViewById(R.id.et_voyager_config_history_expire_time);
            this.mEditBizType1 = (EditText) findViewById(R.id.et_voyager_biz_type1);
            this.mCheckSwitchBiz1 = (CheckBox) findViewById(R.id.cb_voyager_switch1);
            this.mEditBizExpiredTime1 = (EditText) findViewById(R.id.et_biz_expire_time1);
            this.mEditBizMaxCount1 = (EditText) findViewById(R.id.et_biz_max_count1);
            this.mEditBizMaxSize1 = (EditText) findViewById(R.id.et_biz_max_size1);
            this.mEditBizNetType1 = (EditText) findViewById(R.id.et_biz_net_type1);
            this.mEditBizType2 = (EditText) findViewById(R.id.et_voyager_biz_type2);
            this.mCheckSwitchBiz2 = (CheckBox) findViewById(R.id.cb_voyager_switch2);
            this.mEditBizExpiredTime2 = (EditText) findViewById(R.id.et_biz_expire_time2);
            this.mEditBizMaxCount2 = (EditText) findViewById(R.id.et_biz_max_count2);
            this.mEditBizMaxSize2 = (EditText) findViewById(R.id.et_biz_max_size2);
            this.mEditBizNetType2 = (EditText) findViewById(R.id.et_biz_net_type2);
            this.mBtnVoyagerSaveConfig = (Button) findViewById(R.id.btn_voyager_save_config);
            this.mEditUploadType = (EditText) findViewById(R.id.et_upload_type);
            this.mEditUploadId = (EditText) findViewById(R.id.et_upload_dataId);
            this.mEditUploadSpace = (EditText) findViewById(R.id.et_upload_filter);
            this.mEditUploadMaxSize = (EditText) findViewById(R.id.et_upload_max_size);
            this.mEditUploadStartTime = (EditText) findViewById(R.id.et_upload_start_time);
            this.mEditUploadEndTime = (EditText) findViewById(R.id.et_upload_end_time);
            this.mBtnActiveUpload = (Button) findViewById(R.id.btn_active_upload);
            this.mBtnActiveReUpload = (Button) findViewById(R.id.btn_active_re_upload);
            this.mBtnActiveSnapUpload = (Button) findViewById(R.id.btn_active_snap_upload);
            this.mBtnActiveSnapReUpload = (Button) findViewById(R.id.btn_active_snap_re_upload);
            this.mTextRetrievePlat = (TextView) findViewById(R.id.tv_retrieve_plat_intro);
            this.mBtnGetCuid = (Button) findViewById(R.id.btn_get_cuid);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("1、统一长链接SDK接入文档(无需接入IM SDK)\n");
            stringBuffer.append("http://wiki.baidu.com/pages/viewpage.action?pageId=1169474874\n");
            stringBuffer.append("2、前往回捞平台下发回捞命令\n");
            stringBuffer.append("http://performance.baidu.com/#/fetchlog/fetchjob\n");
            stringBuffer.append("3、获取cuid：\n");
            stringBuffer.append("http://mcms.baidu.com/cuidhelper/");
            this.mTextRetrievePlat.setText(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveConfig() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String str = "0";
                if (!this.mCheckTotalSwitch.isChecked()) {
                    obj = "0";
                } else {
                    obj = "1";
                }
                jSONObject.put(SetImageWatermarkTypeReqMsg.SWITCH, obj);
                if (!this.mCheckClear.isChecked()) {
                    obj2 = "0";
                } else {
                    obj2 = "1";
                }
                jSONObject.put("clear", obj2);
                String str2 = ((Object) this.mEditSingleSize.getText()) + "";
                if (TextUtils.isEmpty(str2)) {
                    str2 = "2";
                }
                jSONObject.put("singlesize", str2);
                String str3 = ((Object) this.mEditTotalSize.getText()) + "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "100";
                }
                jSONObject.put("totalsize", str3);
                String str4 = ((Object) this.mEditSpaceSize.getText()) + "";
                boolean isEmpty = TextUtils.isEmpty(str4);
                Object obj5 = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                if (isEmpty) {
                    str4 = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                }
                jSONObject.put("spacesize", str4);
                String str5 = ((Object) this.mEditSpaceTimeout.getText()) + "";
                if (TextUtils.isEmpty(str5)) {
                    str5 = "7";
                }
                jSONObject.put("spacetimeout", str5);
                String str6 = ((Object) this.mEditIdSize.getText()) + "";
                if (!TextUtils.isEmpty(str6)) {
                    obj5 = str6;
                }
                jSONObject.put("idsize", obj5);
                JSONObject jSONObject2 = new JSONObject();
                String str7 = ((Object) this.mEditSpace1.getText()) + "";
                if (!TextUtils.isEmpty(str7.trim())) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (!this.mCheckSpaceSwitch1.isChecked()) {
                        obj4 = "0";
                    } else {
                        obj4 = "1";
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(SetImageWatermarkTypeReqMsg.SWITCH, obj4);
                    jSONObject4.put("size", ((Object) this.mEditSpaceSize1.getText()) + "");
                    jSONObject4.put("time", ((Object) this.mEditSpaceTime1.getText()) + "");
                    jSONObject3.put("data", jSONObject4);
                    jSONObject2.put(str7, jSONObject3);
                }
                String str8 = ((Object) this.mEditSpace2.getText()) + "";
                if (!TextUtils.isEmpty(str8.trim())) {
                    JSONObject jSONObject5 = new JSONObject();
                    if (!this.mCheckSpaceSwitch2.isChecked()) {
                        obj3 = "0";
                    } else {
                        obj3 = "1";
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(SetImageWatermarkTypeReqMsg.SWITCH, obj3);
                    jSONObject6.put("size", ((Object) this.mEditSpaceSize2.getText()) + "");
                    jSONObject6.put("time", ((Object) this.mEditSpaceTime2.getText()) + "");
                    jSONObject5.put("data", jSONObject6);
                    jSONObject2.put(str8, jSONObject5);
                }
                String str9 = ((Object) this.mEditSpace3.getText()) + "";
                if (!TextUtils.isEmpty(str9.trim())) {
                    JSONObject jSONObject7 = new JSONObject();
                    if (this.mCheckSpaceSwitch3.isChecked()) {
                        str = "1";
                    }
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put(SetImageWatermarkTypeReqMsg.SWITCH, str);
                    jSONObject8.put("size", ((Object) this.mEditSpaceSize3.getText()) + "");
                    jSONObject8.put("time", ((Object) this.mEditSpaceTime3.getText()) + "");
                    jSONObject7.put("data", jSONObject8);
                    jSONObject2.put(str9, jSONObject7);
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put("set", jSONObject2);
                }
                xz9 xz9Var = (xz9) ServiceManager.getService(xz9.a);
                if (xz9Var != null) {
                    xz9Var.a(jSONObject);
                    Toast.makeText(this, "配置成功！\n" + jSONObject.toString(), 1).show();
                    return;
                }
                Toast.makeText(this, "无法获取service！请正确配置easybox 服务框架！", 0).show();
            } catch (JSONException e) {
                Toast.makeText(this, "配置失败！\n" + e.toString(), 1).show();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveVoyagerConfig() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.mCheckVoyagerSwitch.isChecked()) {
                    obj = "1";
                } else {
                    obj = "0";
                }
                jSONObject.put(SetImageWatermarkTypeReqMsg.SWITCH, obj);
                if (this.mCheckVoyagerClear.isChecked()) {
                    obj2 = "1";
                } else {
                    obj2 = "0";
                }
                jSONObject.put("clear", obj2);
                String str3 = ((Object) this.mEditVoyagerUploadInterval.getText()) + "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "5";
                }
                jSONObject.put("upload_interval", str3);
                String str4 = ((Object) this.mEditUploadMaxCount.getText()) + "";
                if (TextUtils.isEmpty(str4)) {
                    str4 = "10";
                }
                jSONObject.put("max_count_per_round", str4);
                String str5 = ((Object) this.mEditExpiredTime.getText()) + "";
                String str6 = "7";
                if (TextUtils.isEmpty(str5)) {
                    str5 = "7";
                }
                jSONObject.put("expired_time", str5);
                String str7 = ((Object) this.mEditSingleMaxCount.getText()) + "";
                if (TextUtils.isEmpty(str7)) {
                    str7 = "5";
                }
                jSONObject.put("single_max_count", str7);
                String str8 = ((Object) this.mEditSingleMaxSize.getText()) + "";
                boolean isEmpty = TextUtils.isEmpty(str8);
                String str9 = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                if (isEmpty) {
                    str8 = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                }
                jSONObject.put("single_max_size", str8);
                String str10 = ((Object) this.mEditTotalMaxCount.getText()) + "";
                if (TextUtils.isEmpty(str10)) {
                    str10 = "100";
                }
                jSONObject.put("total_max_count", str10);
                String str11 = ((Object) this.mEditTotalMaxSize.getText()) + "";
                if (TextUtils.isEmpty(str11)) {
                    str11 = "100";
                }
                jSONObject.put("total_max_size", str11);
                String str12 = ((Object) this.mEditHistoryMaxCount.getText()) + "";
                if (TextUtils.isEmpty(str12)) {
                    str12 = "5000";
                }
                jSONObject.put("history_max_count", str12);
                String str13 = ((Object) this.mEditHistoryDelCount.getText()) + "";
                if (TextUtils.isEmpty(str13)) {
                    str13 = "500";
                }
                jSONObject.put("history_del_count", str13);
                String str14 = ((Object) this.mEditHistoryExpiredTime.getText()) + "";
                if (TextUtils.isEmpty(str14)) {
                    str14 = "15";
                }
                jSONObject.put("history_expire_time", str14);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String str15 = ((Object) this.mEditBizType1.getText()) + "";
                if (TextUtils.isEmpty(str15)) {
                    str15 = "fetchlog";
                }
                if (this.mCheckSwitchBiz1.isChecked()) {
                    obj3 = "1";
                } else {
                    obj3 = "0";
                }
                jSONObject3.put(SetImageWatermarkTypeReqMsg.SWITCH, obj3);
                String str16 = ((Object) this.mEditBizExpiredTime1.getText()) + "";
                if (TextUtils.isEmpty(str16)) {
                    str16 = "7";
                }
                jSONObject3.put("expired_time", str16);
                String str17 = ((Object) this.mEditBizMaxCount1.getText()) + "";
                if (TextUtils.isEmpty(str17)) {
                    str17 = "5";
                }
                jSONObject3.put("single_max_count", str17);
                String str18 = ((Object) this.mEditBizMaxSize1.getText()) + "";
                if (TextUtils.isEmpty(str18)) {
                    str18 = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                }
                jSONObject3.put("single_max_size", str18);
                String str19 = ((Object) this.mEditBizNetType1.getText()) + "";
                if (TextUtils.isEmpty(str19)) {
                    str19 = "0";
                }
                jSONObject3.put("only_wifi", str19);
                jSONObject2.put(str15, jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                String str20 = ((Object) this.mEditBizType2.getText()) + "";
                if (TextUtils.isEmpty(str20)) {
                    str20 = "acupload";
                }
                if (this.mCheckSwitchBiz2.isChecked()) {
                    obj4 = "1";
                } else {
                    obj4 = "0";
                }
                jSONObject4.put(SetImageWatermarkTypeReqMsg.SWITCH, obj4);
                String str21 = ((Object) this.mEditBizExpiredTime2.getText()) + "";
                if (!TextUtils.isEmpty(str21)) {
                    str6 = str21;
                }
                jSONObject4.put("expired_time", str6);
                String str22 = ((Object) this.mEditBizMaxCount2.getText()) + "";
                if (TextUtils.isEmpty(str22)) {
                    str = "5";
                } else {
                    str = str22;
                }
                jSONObject4.put("single_max_count", str);
                String str23 = ((Object) this.mEditBizMaxSize2.getText()) + "";
                if (!TextUtils.isEmpty(str18)) {
                    str9 = str23;
                }
                jSONObject4.put("single_max_size", str9);
                String str24 = ((Object) this.mEditBizNetType2.getText()) + "";
                if (TextUtils.isEmpty(str19)) {
                    str2 = "0";
                } else {
                    str2 = str24;
                }
                jSONObject4.put("only_wifi", str2);
                jSONObject2.put(str20, jSONObject4);
                jSONObject.put("set", jSONObject2);
                pz9 pz9Var = (pz9) ServiceManager.getService(pz9.a);
                if (pz9Var != null) {
                    pz9Var.d(jSONObject);
                    Toast.makeText(this, "voyager配置成功！\n" + jSONObject.toString(), 1).show();
                } else {
                    Toast.makeText(this, "无法获取service！请正确配置easybox服务框架！", 0).show();
                }
            } catch (JSONException e) {
                Toast.makeText(this, "voyager配置失败！\n" + e.toString(), 1).show();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveIdConfig() {
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                String str = ((Object) this.mEditIdName1.getText()) + "";
                String str2 = "1";
                if (!TextUtils.isEmpty(str.trim())) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (this.mCheckIdSwitch1.isChecked()) {
                        obj2 = "1";
                    } else {
                        obj2 = "0";
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("yalogswitch", obj2);
                    jSONObject4.put("yalogsize", ((Object) this.mEditIdSize1.getText()) + "");
                    jSONObject3.put("data", jSONObject4);
                    jSONObject3.put("version", String.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject2.put(str, jSONObject3);
                }
                String str3 = ((Object) this.mEditIdName2.getText()) + "";
                if (!TextUtils.isEmpty(str3.trim())) {
                    JSONObject jSONObject5 = new JSONObject();
                    if (this.mCheckIdSwitch2.isChecked()) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("yalogswitch", obj);
                    jSONObject6.put("yalogsize", ((Object) this.mEditIdSize2.getText()) + "");
                    jSONObject5.put("data", jSONObject6);
                    jSONObject5.put("version", String.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject2.put(str3, jSONObject5);
                }
                String str4 = ((Object) this.mEditIdName3.getText()) + "";
                if (!TextUtils.isEmpty(str4.trim())) {
                    JSONObject jSONObject7 = new JSONObject();
                    if (!this.mCheckIdSwitch3.isChecked()) {
                        str2 = "0";
                    }
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("yalogswitch", str2);
                    jSONObject8.put("yalogsize", ((Object) this.mEditIdSize3.getText()) + "");
                    jSONObject7.put("data", jSONObject8);
                    jSONObject7.put("version", String.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject2.put(str4, jSONObject7);
                }
                jSONObject.put("set", jSONObject2);
                if (jSONObject2.length() == 0) {
                    Toast.makeText(this, "无id配置", 0).show();
                    return;
                }
                xz9 xz9Var = (xz9) ServiceManager.getService(xz9.a);
                if (xz9Var != null) {
                    xz9Var.b(jSONObject, true);
                    Toast.makeText(this, "配置成功！\n" + jSONObject.toString(), 1).show();
                    return;
                }
                Toast.makeText(this, "无法获取service！请正确配置easybox 服务框架！", 0).show();
            } catch (JSONException e) {
                Toast.makeText(this, "配置失败！\n" + e.toString(), 1).show();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeLog(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65560, this, i) == null) {
            String str = ((Object) this.mEditLogContent.getText()) + "";
            if (TextUtils.isEmpty(str)) {
                str = "no data";
            }
            String str2 = ((Object) this.mEditLogSpace.getText()) + "";
            if (TextUtils.isEmpty(str2)) {
                str2 = "debug";
            }
            ExecutorUtilsExt.postOnElastic(new Runnable(this, i, LoggerManager.getLogger(str2), str) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugYaLogActivity this$0;
                public final /* synthetic */ int val$count;
                public final /* synthetic */ String val$finalContent;
                public final /* synthetic */ Logger val$logger;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), r8, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$count = i;
                    this.val$logger = r8;
                    this.val$finalContent = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (int i2 = 0; i2 < this.val$count; i2++) {
                            this.val$logger.d("100", "YaLogTestDebug", this.val$finalContent);
                            this.val$logger.v(ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, "YaLogTestVerbose", this.val$finalContent);
                            this.val$logger.i(WorkPostNotifyFlutterData.FAIL_POST, "YaLogTestInfo", this.val$finalContent);
                            this.val$logger.w("103", "YaLogTestWarn", this.val$finalContent);
                            this.val$logger.e("104", "YaLogTestError", this.val$finalContent);
                        }
                        this.val$logger.flush(false);
                        new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugYaLogActivity.20.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass20 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    Toast.makeText(this.this$1.this$0, "写入成功！", 0).show();
                                }
                            }
                        });
                    }
                }
            }, "writeToYaLogDebug", 2);
        }
    }
}
