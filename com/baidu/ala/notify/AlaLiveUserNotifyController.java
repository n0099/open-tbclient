package com.baidu.ala.notify;

import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaLiveUserNotifyController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaLiveUserNotifyDialog mBdAlertDialog;
    public TbPageContext mTbPageContext;

    public AlaLiveUserNotifyController(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTbPageContext = tbPageContext;
    }

    private void showNotifyDialog(int i2, AlaLiveUserNotifyData alaLiveUserNotifyData, ArrayList<AlaLiveUserNotifyData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65537, this, i2, alaLiveUserNotifyData, arrayList) == null) || this.mTbPageContext == null) {
            return;
        }
        if (this.mBdAlertDialog == null) {
            this.mBdAlertDialog = new AlaLiveUserNotifyDialog(this.mTbPageContext.getPageActivity());
        }
        this.mBdAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener(this, i2, arrayList) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaLiveUserNotifyController this$0;
            public final /* synthetic */ ArrayList val$dataList;
            public final /* synthetic */ int val$index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), arrayList};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$index = i2;
                this.val$dataList = arrayList;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                    this.this$0.showNextNotifyDialog(this.val$index + 1, this.val$dataList);
                }
            }
        });
        this.mBdAlertDialog.show(alaLiveUserNotifyData);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AlaLiveUserNotifyDialog alaLiveUserNotifyDialog = this.mBdAlertDialog;
            if (alaLiveUserNotifyDialog != null && alaLiveUserNotifyDialog.isShowing()) {
                this.mBdAlertDialog.dismiss();
            }
            this.mBdAlertDialog = null;
            this.mTbPageContext = null;
        }
    }

    public void showNextNotifyDialog(int i2, ArrayList<AlaLiveUserNotifyData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, arrayList) == null) || i2 < 0 || i2 >= ListUtils.getCount(arrayList)) {
            return;
        }
        showNotifyDialog(i2, arrayList.get(i2), arrayList);
    }
}
