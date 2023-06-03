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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.b0;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.OutputStream;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class GrantPermissionActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public z b;

    public GrantPermissionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
    }

    public static void b(Context context, IntentSender intentSender, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, context, intentSender, i, str) == null) {
            Intent intent = new Intent(context, GrantPermissionActivity.class);
            intent.putExtra("requestAccessIntentSender", intentSender);
            intent.putExtra("request_code", i);
            intent.putExtra("request_time_stamp", str);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public final void a(int i) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b == null) {
            return;
        }
        if (i == 1) {
            ContentResolver contentResolver = getContentResolver();
            z zVar = this.b;
            int delete = contentResolver.delete(zVar.a, zVar.e, zVar.f);
            y yVar = this.b.i;
            if (yVar != null) {
                yVar.onPermitted(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            ContentResolver contentResolver2 = getContentResolver();
            z zVar2 = this.b;
            int update = contentResolver2.update(zVar2.a, zVar2.g, zVar2.e, zVar2.f);
            y yVar2 = this.b.i;
            if (yVar2 != null) {
                yVar2.onPermitted(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ContentResolver contentResolver3 = getContentResolver();
            z zVar3 = this.b;
            ParcelFileDescriptor openFileDescriptor = contentResolver3.openFileDescriptor(zVar3.a, zVar3.b);
            y yVar3 = this.b.i;
            if (yVar3 != null) {
                yVar3.onPermitted(openFileDescriptor);
            }
        } else if (i == 4) {
            ContentResolver contentResolver4 = getContentResolver();
            z zVar4 = this.b;
            ParcelFileDescriptor openFileDescriptor2 = contentResolver4.openFileDescriptor(zVar4.a, zVar4.b, zVar4.h);
            y yVar4 = this.b.i;
            if (yVar4 != null) {
                yVar4.onPermitted(openFileDescriptor2);
            }
        } else if (i == 5) {
            ContentResolver contentResolver5 = getContentResolver();
            z zVar5 = this.b;
            AssetFileDescriptor openAssetFile = contentResolver5.openAssetFile(zVar5.a, zVar5.b, zVar5.h);
            y yVar5 = this.b.i;
            if (yVar5 != null) {
                yVar5.onPermitted(openAssetFile);
            }
        } else if (i == 6) {
            ContentResolver contentResolver6 = getContentResolver();
            z zVar6 = this.b;
            AssetFileDescriptor openAssetFileDescriptor = contentResolver6.openAssetFileDescriptor(zVar6.a, zVar6.b);
            y yVar6 = this.b.i;
            if (yVar6 != null) {
                yVar6.onPermitted(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            ContentResolver contentResolver7 = getContentResolver();
            z zVar7 = this.b;
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver7.openAssetFileDescriptor(zVar7.a, zVar7.b, zVar7.h);
            y yVar7 = this.b.i;
            if (yVar7 != null) {
                yVar7.onPermitted(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ContentResolver contentResolver8 = getContentResolver();
            z zVar8 = this.b;
            ParcelFileDescriptor openFile = contentResolver8.openFile(zVar8.a, zVar8.b, zVar8.h);
            y yVar8 = this.b.i;
            if (yVar8 != null) {
                yVar8.onPermitted(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.b.a);
            y yVar9 = this.b.i;
            if (yVar9 != null) {
                yVar9.onPermitted(openOutputStream);
            }
        } else if (i == 10) {
            ContentResolver contentResolver9 = getContentResolver();
            z zVar9 = this.b;
            OutputStream openOutputStream2 = contentResolver9.openOutputStream(zVar9.a, zVar9.b);
            y yVar10 = this.b.i;
            if (yVar10 != null) {
                yVar10.onPermitted(openOutputStream2);
            }
        } else if (i == 11) {
            ContentResolver contentResolver10 = getContentResolver();
            z zVar10 = this.b;
            AssetFileDescriptor openTypedAssetFile = contentResolver10.openTypedAssetFile(zVar10.a, zVar10.c, zVar10.d, zVar10.h);
            y yVar11 = this.b.i;
            if (yVar11 != null) {
                yVar11.onPermitted(openTypedAssetFile);
            }
        } else if (i == 12) {
            ContentResolver contentResolver11 = getContentResolver();
            z zVar11 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver11.openTypedAssetFileDescriptor(zVar11.a, zVar11.c, zVar11.d);
            y yVar12 = this.b.i;
            if (yVar12 != null) {
                yVar12.onPermitted(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            ContentResolver contentResolver12 = getContentResolver();
            z zVar12 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor2 = contentResolver12.openTypedAssetFileDescriptor(zVar12.a, zVar12.c, zVar12.d, zVar12.h);
            y yVar13 = this.b.i;
            if (yVar13 != null) {
                yVar13.onPermitted(openTypedAssetFileDescriptor2);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IntentSender intentSender = (IntentSender) getIntent().getParcelableExtra("requestAccessIntentSender");
            if (intentSender == null) {
                finish();
                return;
            }
            try {
                startIntentSenderForResult(intentSender, this.a, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        y yVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            z zVar = this.b;
            if (zVar == null) {
                finish();
                return;
            }
            if (i2 == -1) {
                try {
                    a(i);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (i2 == 0 && (yVar = zVar.i) != null) {
                yVar.onRefused();
            }
            b0.b().f(String.valueOf(this.b.j));
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d003c);
            Intent intent = getIntent();
            this.a = intent.getIntExtra("request_code", -1);
            z c = b0.b().c(intent.getStringExtra("request_time_stamp"));
            this.b = c;
            if (c != null) {
                c();
            } else {
                finish();
            }
        }
    }
}
