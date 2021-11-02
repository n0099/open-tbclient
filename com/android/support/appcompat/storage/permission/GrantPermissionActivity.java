package com.android.support.appcompat.storage.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import b.b.a.a.c.a;
import b.b.a.a.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.OutputStream;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class GrantPermissionActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int REQEUST_PEMITED = -1;
    public static final int REQEUST_REFUSED = 0;
    public static final String TAG = "MediaFileProcessor";
    public transient /* synthetic */ FieldHolder $fh;
    public int mRequestCode;
    public b mRequestInfo;

    public GrantPermissionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestCode = -1;
    }

    private void dealPermitResult(int i2) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            if (i2 == 1) {
                ContentResolver contentResolver = getContentResolver();
                b bVar = this.mRequestInfo;
                int delete = contentResolver.delete(bVar.f30033a, bVar.f30037e, bVar.f30038f);
                a aVar = this.mRequestInfo.f30041i;
                if (aVar != null) {
                    aVar.a(Integer.valueOf(delete));
                }
            } else if (i2 == 2) {
                ContentResolver contentResolver2 = getContentResolver();
                b bVar2 = this.mRequestInfo;
                int update = contentResolver2.update(bVar2.f30033a, bVar2.f30039g, bVar2.f30037e, bVar2.f30038f);
                a aVar2 = this.mRequestInfo.f30041i;
                if (aVar2 != null) {
                    aVar2.a(Integer.valueOf(update));
                }
            } else if (i2 == 3) {
                ContentResolver contentResolver3 = getContentResolver();
                b bVar3 = this.mRequestInfo;
                ParcelFileDescriptor openFileDescriptor = contentResolver3.openFileDescriptor(bVar3.f30033a, bVar3.f30034b);
                a aVar3 = this.mRequestInfo.f30041i;
                if (aVar3 != null) {
                    aVar3.a(openFileDescriptor);
                }
            } else if (i2 == 4) {
                ContentResolver contentResolver4 = getContentResolver();
                b bVar4 = this.mRequestInfo;
                ParcelFileDescriptor openFileDescriptor2 = contentResolver4.openFileDescriptor(bVar4.f30033a, bVar4.f30034b, bVar4.f30040h);
                a aVar4 = this.mRequestInfo.f30041i;
                if (aVar4 != null) {
                    aVar4.a(openFileDescriptor2);
                }
            } else if (i2 == 5) {
                ContentResolver contentResolver5 = getContentResolver();
                b bVar5 = this.mRequestInfo;
                AssetFileDescriptor openAssetFile = contentResolver5.openAssetFile(bVar5.f30033a, bVar5.f30034b, bVar5.f30040h);
                a aVar5 = this.mRequestInfo.f30041i;
                if (aVar5 != null) {
                    aVar5.a(openAssetFile);
                }
            } else if (i2 == 6) {
                ContentResolver contentResolver6 = getContentResolver();
                b bVar6 = this.mRequestInfo;
                AssetFileDescriptor openAssetFileDescriptor = contentResolver6.openAssetFileDescriptor(bVar6.f30033a, bVar6.f30034b);
                a aVar6 = this.mRequestInfo.f30041i;
                if (aVar6 != null) {
                    aVar6.a(openAssetFileDescriptor);
                }
            } else if (i2 == 7) {
                ContentResolver contentResolver7 = getContentResolver();
                b bVar7 = this.mRequestInfo;
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver7.openAssetFileDescriptor(bVar7.f30033a, bVar7.f30034b, bVar7.f30040h);
                a aVar7 = this.mRequestInfo.f30041i;
                if (aVar7 != null) {
                    aVar7.a(openAssetFileDescriptor2);
                }
            } else if (i2 == 8) {
                ContentResolver contentResolver8 = getContentResolver();
                b bVar8 = this.mRequestInfo;
                ParcelFileDescriptor openFile = contentResolver8.openFile(bVar8.f30033a, bVar8.f30034b, bVar8.f30040h);
                a aVar8 = this.mRequestInfo.f30041i;
                if (aVar8 != null) {
                    aVar8.a(openFile);
                }
            } else if (i2 == 9) {
                OutputStream openOutputStream = getContentResolver().openOutputStream(this.mRequestInfo.f30033a);
                a aVar9 = this.mRequestInfo.f30041i;
                if (aVar9 != null) {
                    aVar9.a(openOutputStream);
                }
            } else if (i2 == 10) {
                ContentResolver contentResolver9 = getContentResolver();
                b bVar9 = this.mRequestInfo;
                OutputStream openOutputStream2 = contentResolver9.openOutputStream(bVar9.f30033a, bVar9.f30034b);
                a aVar10 = this.mRequestInfo.f30041i;
                if (aVar10 != null) {
                    aVar10.a(openOutputStream2);
                }
            } else if (i2 == 11) {
                ContentResolver contentResolver10 = getContentResolver();
                b bVar10 = this.mRequestInfo;
                AssetFileDescriptor openTypedAssetFile = contentResolver10.openTypedAssetFile(bVar10.f30033a, bVar10.f30035c, bVar10.f30036d, bVar10.f30040h);
                a aVar11 = this.mRequestInfo.f30041i;
                if (aVar11 != null) {
                    aVar11.a(openTypedAssetFile);
                }
            } else if (i2 == 12) {
                ContentResolver contentResolver11 = getContentResolver();
                b bVar11 = this.mRequestInfo;
                AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver11.openTypedAssetFileDescriptor(bVar11.f30033a, bVar11.f30035c, bVar11.f30036d);
                a aVar12 = this.mRequestInfo.f30041i;
                if (aVar12 != null) {
                    aVar12.a(openTypedAssetFileDescriptor);
                }
            } else if (i2 == 13) {
                ContentResolver contentResolver12 = getContentResolver();
                b bVar12 = this.mRequestInfo;
                AssetFileDescriptor openTypedAssetFileDescriptor2 = contentResolver12.openTypedAssetFileDescriptor(bVar12.f30033a, bVar12.f30035c, bVar12.f30036d, bVar12.f30040h);
                a aVar13 = this.mRequestInfo.f30041i;
                if (aVar13 != null) {
                    aVar13.a(openTypedAssetFileDescriptor2);
                }
            }
        }
    }

    public static void showPermissionPage(Context context, IntentSender intentSender, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65538, null, context, intentSender, i2, str) == null) {
            Intent intent = new Intent(context, GrantPermissionActivity.class);
            intent.putExtra("requestAccessIntentSender", intentSender);
            intent.putExtra("request_code", i2);
            intent.putExtra("request_time_stamp", str);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    private void startPermissionRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                startIntentSenderForResult((IntentSender) getIntent().getParcelableExtra("requestAccessIntentSender"), this.mRequestCode, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                try {
                    dealPermitResult(i2);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            } else if (i3 == 0 && (aVar = this.mRequestInfo.f30041i) != null) {
                aVar.b();
            }
            b.b.a.a.c.c.a.a().c(String.valueOf(this.mRequestInfo.j));
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(b.b.a.a.a.activity_grant_permission);
            Intent intent = getIntent();
            this.mRequestCode = intent.getIntExtra("request_code", -1);
            this.mRequestInfo = b.b.a.a.c.c.a.a().b(intent.getStringExtra("request_time_stamp"));
            startPermissionRequest();
        }
    }
}
