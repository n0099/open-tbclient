package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.IPermissionPolicy;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionRequestDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.cr4;
import com.repackage.f9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class PermissionJudgePolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EMPTY_REQUEST_CODE = -1;
    public static final ArrayList<String> NEED_EXTRA_DIALOG_PERMISSIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public PermissionDialogClickListener mDialogClickListener;
    public PermissionRequestDialog.OnClickCallback mExtraDialogRefuseOneByOneCallback;
    public EXTRA_DIALOG_REFUSE_POLICY mExtraDialogRefusePolicy;
    public PermissionRequestDialog.OnClickCallback mExtraDialogRejectAllCallback;
    public IExtraDialogCloseCallback mIExtraDialogCloseCallback;
    public ISystemPermissionDialogShowCallBack mISystemPermissionDialogShowCallBack;
    public List<String> mNeedExtraDialogPermissionList;
    public OnPermissionsGrantedListener mOnPermissionsGrantedListener;
    public PermissionRequestDialog mPermissionRequestDialog;
    public int mRequestCode;
    public ArrayList<String> requestPermissionList;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class EXTRA_DIALOG_REFUSE_POLICY {
        public static final /* synthetic */ EXTRA_DIALOG_REFUSE_POLICY[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EXTRA_DIALOG_REFUSE_POLICY Refuse_one_by_one;
        public static final EXTRA_DIALOG_REFUSE_POLICY Reject_all;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-867438724, "Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy$EXTRA_DIALOG_REFUSE_POLICY;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-867438724, "Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy$EXTRA_DIALOG_REFUSE_POLICY;");
                    return;
                }
            }
            Reject_all = new EXTRA_DIALOG_REFUSE_POLICY("Reject_all", 0);
            EXTRA_DIALOG_REFUSE_POLICY extra_dialog_refuse_policy = new EXTRA_DIALOG_REFUSE_POLICY("Refuse_one_by_one", 1);
            Refuse_one_by_one = extra_dialog_refuse_policy;
            $VALUES = new EXTRA_DIALOG_REFUSE_POLICY[]{Reject_all, extra_dialog_refuse_policy};
        }

        public EXTRA_DIALOG_REFUSE_POLICY(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EXTRA_DIALOG_REFUSE_POLICY valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EXTRA_DIALOG_REFUSE_POLICY) Enum.valueOf(EXTRA_DIALOG_REFUSE_POLICY.class, str) : (EXTRA_DIALOG_REFUSE_POLICY) invokeL.objValue;
        }

        public static EXTRA_DIALOG_REFUSE_POLICY[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EXTRA_DIALOG_REFUSE_POLICY[]) $VALUES.clone() : (EXTRA_DIALOG_REFUSE_POLICY[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface IExtraDialogCloseCallback {
        void onClose();
    }

    /* loaded from: classes3.dex */
    public interface ISystemPermissionDialogShowCallBack {
        void onShow();
    }

    /* loaded from: classes3.dex */
    public interface OnPermissionsGrantedListener {
        void onPermissionsGranted();
    }

    /* loaded from: classes3.dex */
    public interface PermissionDialogClickListener {
        void onDialogCaneled(String str);

        void onDialogComfirmed(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(624273217, "Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(624273217, "Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy;");
                return;
            }
        }
        NEED_EXTRA_DIALOG_PERMISSIONS = new ArrayList<>(Arrays.asList("android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.ACCESS_COARSE_LOCATION"));
    }

    public PermissionJudgePolicy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRequestCode = -1;
        this.mExtraDialogRefusePolicy = EXTRA_DIALOG_REFUSE_POLICY.Reject_all;
        this.mExtraDialogRejectAllCallback = new PermissionRequestDialog.OnClickCallback(this) { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PermissionJudgePolicy this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
            public void onClickClose(Activity activity, String str) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, str) == null) || this.this$0.mPermissionRequestDialog == null) {
                    return;
                }
                this.this$0.mPermissionRequestDialog.dismiss();
                if (this.this$0.mIExtraDialogCloseCallback != null) {
                    this.this$0.mIExtraDialogCloseCallback.onClose();
                }
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
            public void onClickContinue(Activity activity, String str) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str) == null) || this.this$0.mPermissionRequestDialog == null) {
                    return;
                }
                this.this$0.mNeedExtraDialogPermissionList.remove(str);
                if (!ListUtils.isEmpty(this.this$0.mNeedExtraDialogPermissionList)) {
                    this.this$0.processExtraPermissionDialog(activity);
                    return;
                }
                this.this$0.mPermissionRequestDialog.dismiss();
                PermissionJudgePolicy permissionJudgePolicy = this.this$0;
                permissionJudgePolicy.startRequestPermissionForSystem(activity, permissionJudgePolicy.mRequestCode);
            }
        };
        this.mExtraDialogRefuseOneByOneCallback = new PermissionRequestDialog.OnClickCallback(this) { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PermissionJudgePolicy this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
            public void onClickClose(Activity activity, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, str) == null) {
                    this.this$0.requestPermissionList.remove(str);
                    this.this$0.mNeedExtraDialogPermissionList.remove(str);
                    if (!ListUtils.isEmpty(this.this$0.mNeedExtraDialogPermissionList)) {
                        this.this$0.processExtraPermissionDialog(activity);
                        return;
                    }
                    this.this$0.mPermissionRequestDialog.dismiss();
                    PermissionJudgePolicy permissionJudgePolicy = this.this$0;
                    permissionJudgePolicy.startRequestPermissionForSystem(activity, permissionJudgePolicy.mRequestCode);
                }
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionRequestDialog.OnClickCallback
            public void onClickContinue(Activity activity, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str) == null) {
                    this.this$0.mNeedExtraDialogPermissionList.remove(str);
                    if (!ListUtils.isEmpty(this.this$0.mNeedExtraDialogPermissionList)) {
                        this.this$0.processExtraPermissionDialog(activity);
                        return;
                    }
                    this.this$0.mPermissionRequestDialog.dismiss();
                    PermissionJudgePolicy permissionJudgePolicy = this.this$0;
                    permissionJudgePolicy.startRequestPermissionForSystem(activity, permissionJudgePolicy.mRequestCode);
                }
            }
        };
        this.requestPermissionList = new ArrayList<>();
    }

    private List<String> getNeedExtraDialogPermissionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            LinkedList linkedList = new LinkedList();
            Iterator<String> it = this.requestPermissionList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (NEED_EXTRA_DIALOG_PERMISSIONS.contains(next)) {
                    linkedList.add(next);
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    private b9 getPageContext(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, activity)) == null) {
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            return null;
        }
        return (b9) invokeL.objValue;
    }

    private int getPermissionDescriptionId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) ? (TextUtils.isEmpty(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) ? R.string.obfuscated_res_0x7f0f0fae : ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) ? R.string.obfuscated_res_0x7f0f0fb3 : "android.permission.CAMERA".equals(str) ? R.string.obfuscated_res_0x7f0f0fab : "android.permission.RECORD_AUDIO".equals(str) ? R.string.obfuscated_res_0x7f0f0fb4 : "android.permission.READ_PHONE_STATE".equals(str) ? R.string.obfuscated_res_0x7f0f0fad : "android.permission.SEND_SMS".equals(str) ? R.string.obfuscated_res_0x7f0f0fb5 : "android.permission.CALL_PHONE".equals(str) ? R.string.obfuscated_res_0x7f0f0fac : R.string.obfuscated_res_0x7f0f0fae : invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processExtraPermissionDialog(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, activity) == null) || getPageContext(activity) == null || ListUtils.isEmpty(this.mNeedExtraDialogPermissionList)) {
            return;
        }
        if (this.mPermissionRequestDialog == null) {
            PermissionRequestDialog permissionRequestDialog = new PermissionRequestDialog(activity);
            this.mPermissionRequestDialog = permissionRequestDialog;
            if (this.mExtraDialogRefusePolicy == EXTRA_DIALOG_REFUSE_POLICY.Refuse_one_by_one) {
                permissionRequestDialog.setOnClickCallback(this.mExtraDialogRefuseOneByOneCallback);
            } else {
                permissionRequestDialog.setOnClickCallback(this.mExtraDialogRejectAllCallback);
            }
        }
        this.mPermissionRequestDialog.setRequestPermission(this.mNeedExtraDialogPermissionList.get(0));
        this.mPermissionRequestDialog.create(getPageContext(activity));
        this.mPermissionRequestDialog.onChangeSkinType();
        this.mPermissionRequestDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRequestPermissionForSystem(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65550, this, activity, i) == null) || ListUtils.isEmpty(this.requestPermissionList)) {
            return;
        }
        ISystemPermissionDialogShowCallBack iSystemPermissionDialogShowCallBack = this.mISystemPermissionDialogShowCallBack;
        if (iSystemPermissionDialogShowCallBack != null) {
            iSystemPermissionDialogShowCallBack.onShow();
        }
        if (i == -1) {
            startRequestPermissionInternal(activity);
        } else {
            startRequestPermissionInternal(activity, i);
        }
    }

    private void startRequestPermissionInternal(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, activity) == null) || activity == null) {
            return;
        }
        try {
            ActivityCompat.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), 25040);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void appendRequestPermission(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, activity, str) == null) || TextUtils.isEmpty(str) || checkPermissionGranted(activity, str)) {
            return;
        }
        this.requestPermissionList.add(str);
    }

    public void appendRequestPermissionWithoutGrantedCheck(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.requestPermissionList.add(str);
    }

    public boolean checkPermissionForbidden(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, str)) == null) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return true;
            }
            cr4 cr4Var = new cr4(activity);
            cr4Var.setCanceledOnTouchOutside(false);
            cr4Var.setTitle(R.string.obfuscated_res_0x7f0f0faf);
            cr4Var.setMessageId(getPermissionDescriptionId(str));
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0964, new cr4.e(this, activity, str) { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PermissionJudgePolicy this$0;
                public final /* synthetic */ Activity val$context;
                public final /* synthetic */ String val$permission;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, str};
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
                    this.val$context = activity;
                    this.val$permission = str;
                }

                @Override // com.repackage.cr4.e
                public void onClick(cr4 cr4Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cr4Var2) == null) {
                        cr4Var2.dismiss();
                        Intent intent = new Intent();
                        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", this.val$context.getPackageName(), null));
                        this.val$context.startActivity(intent);
                        if (this.this$0.mDialogClickListener != null) {
                            this.this$0.mDialogClickListener.onDialogComfirmed(this.val$permission);
                        }
                    }
                }
            }).setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new cr4.e(this, str) { // from class: com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PermissionJudgePolicy this$0;
                public final /* synthetic */ String val$permission;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$permission = str;
                }

                @Override // com.repackage.cr4.e
                public void onClick(cr4 cr4Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cr4Var2) == null) {
                        cr4Var2.dismiss();
                        if (this.this$0.mDialogClickListener != null) {
                            this.this$0.mDialogClickListener.onDialogCaneled(this.val$permission);
                        }
                    }
                }
            }).create(f9.a(activity));
            cr4Var.show();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean checkPermissionGranted(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, activity, str)) == null) {
            if (activity == null) {
                return false;
            }
            return ContextCompat.checkPermissionGranted(activity, str);
        }
        return invokeLL.booleanValue;
    }

    public void clearRequestPermissionList() {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (arrayList = this.requestPermissionList) == null) {
            return;
        }
        arrayList.clear();
    }

    public void onPermissionsGranted() {
        OnPermissionsGrantedListener onPermissionsGrantedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (onPermissionsGrantedListener = this.mOnPermissionsGrantedListener) == null) {
            return;
        }
        onPermissionsGrantedListener.onPermissionsGranted();
    }

    public void setDialogClickListener(PermissionDialogClickListener permissionDialogClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, permissionDialogClickListener) == null) {
            this.mDialogClickListener = permissionDialogClickListener;
        }
    }

    public void setOnPermissionsGrantedListener(OnPermissionsGrantedListener onPermissionsGrantedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onPermissionsGrantedListener) == null) {
            this.mOnPermissionsGrantedListener = onPermissionsGrantedListener;
        }
    }

    public boolean startRequestPermission(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) ? startRequestPermission(activity, -1) : invokeL.booleanValue;
    }

    public boolean startRequestPermission(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, activity, i)) == null) ? startRequestPermission(activity, i, EXTRA_DIALOG_REFUSE_POLICY.Reject_all, null) : invokeLI.booleanValue;
    }

    public boolean startRequestPermission(Activity activity, int i, EXTRA_DIALOG_REFUSE_POLICY extra_dialog_refuse_policy, IExtraDialogCloseCallback iExtraDialogCloseCallback, ISystemPermissionDialogShowCallBack iSystemPermissionDialogShowCallBack) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{activity, Integer.valueOf(i), extra_dialog_refuse_policy, iExtraDialogCloseCallback, iSystemPermissionDialogShowCallBack})) == null) {
            this.mISystemPermissionDialogShowCallBack = iSystemPermissionDialogShowCallBack;
            return startRequestPermission(activity, i, extra_dialog_refuse_policy, iExtraDialogCloseCallback);
        }
        return invokeCommon.booleanValue;
    }

    private void startRequestPermissionInternal(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65552, this, activity, i) == null) || activity == null) {
            return;
        }
        try {
            ActivityCompat.requestPermissions(activity, (String[]) this.requestPermissionList.toArray(new String[this.requestPermissionList.size()]), i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public boolean startRequestPermission(Activity activity, int i, EXTRA_DIALOG_REFUSE_POLICY extra_dialog_refuse_policy, IExtraDialogCloseCallback iExtraDialogCloseCallback) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048586, this, activity, i, extra_dialog_refuse_policy, iExtraDialogCloseCallback)) == null) {
            this.mRequestCode = i;
            this.mExtraDialogRefusePolicy = extra_dialog_refuse_policy;
            this.mIExtraDialogCloseCallback = iExtraDialogCloseCallback;
            if (!ApiUtil.shouldCheckPermission()) {
                onPermissionsGranted();
                return false;
            } else if (ListUtils.isEmpty(this.requestPermissionList)) {
                onPermissionsGranted();
                return false;
            } else {
                if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).setCurrentPermissionJudgePolicy(this);
                } else if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).setCurrentPermissionJudgePolicy(this);
                } else if (activity instanceof IPermissionPolicy) {
                    ((IPermissionPolicy) activity).setCurrentPermissionJudgePolicy(this);
                }
                this.mNeedExtraDialogPermissionList = getNeedExtraDialogPermissionList();
                if (getPageContext(activity) != null && !ListUtils.isEmpty(this.mNeedExtraDialogPermissionList)) {
                    processExtraPermissionDialog(activity);
                    return true;
                }
                startRequestPermissionForSystem(activity, this.mRequestCode);
                return true;
            }
        }
        return invokeLILL.booleanValue;
    }
}
