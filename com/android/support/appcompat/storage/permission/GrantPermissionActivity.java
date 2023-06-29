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
import com.baidu.tieba.a0;
import com.baidu.tieba.c0;
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
    public a0 b;

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
            a0 a0Var = this.b;
            int delete = contentResolver.delete(a0Var.a, a0Var.e, a0Var.f);
            z zVar = this.b.i;
            if (zVar != null) {
                zVar.onPermitted(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            ContentResolver contentResolver2 = getContentResolver();
            a0 a0Var2 = this.b;
            int update = contentResolver2.update(a0Var2.a, a0Var2.g, a0Var2.e, a0Var2.f);
            z zVar2 = this.b.i;
            if (zVar2 != null) {
                zVar2.onPermitted(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ContentResolver contentResolver3 = getContentResolver();
            a0 a0Var3 = this.b;
            ParcelFileDescriptor openFileDescriptor = contentResolver3.openFileDescriptor(a0Var3.a, a0Var3.b);
            z zVar3 = this.b.i;
            if (zVar3 != null) {
                zVar3.onPermitted(openFileDescriptor);
            }
        } else if (i == 4) {
            ContentResolver contentResolver4 = getContentResolver();
            a0 a0Var4 = this.b;
            ParcelFileDescriptor openFileDescriptor2 = contentResolver4.openFileDescriptor(a0Var4.a, a0Var4.b, a0Var4.h);
            z zVar4 = this.b.i;
            if (zVar4 != null) {
                zVar4.onPermitted(openFileDescriptor2);
            }
        } else if (i == 5) {
            ContentResolver contentResolver5 = getContentResolver();
            a0 a0Var5 = this.b;
            AssetFileDescriptor openAssetFile = contentResolver5.openAssetFile(a0Var5.a, a0Var5.b, a0Var5.h);
            z zVar5 = this.b.i;
            if (zVar5 != null) {
                zVar5.onPermitted(openAssetFile);
            }
        } else if (i == 6) {
            ContentResolver contentResolver6 = getContentResolver();
            a0 a0Var6 = this.b;
            AssetFileDescriptor openAssetFileDescriptor = contentResolver6.openAssetFileDescriptor(a0Var6.a, a0Var6.b);
            z zVar6 = this.b.i;
            if (zVar6 != null) {
                zVar6.onPermitted(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            ContentResolver contentResolver7 = getContentResolver();
            a0 a0Var7 = this.b;
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver7.openAssetFileDescriptor(a0Var7.a, a0Var7.b, a0Var7.h);
            z zVar7 = this.b.i;
            if (zVar7 != null) {
                zVar7.onPermitted(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ContentResolver contentResolver8 = getContentResolver();
            a0 a0Var8 = this.b;
            ParcelFileDescriptor openFile = contentResolver8.openFile(a0Var8.a, a0Var8.b, a0Var8.h);
            z zVar8 = this.b.i;
            if (zVar8 != null) {
                zVar8.onPermitted(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.b.a);
            z zVar9 = this.b.i;
            if (zVar9 != null) {
                zVar9.onPermitted(openOutputStream);
            }
        } else if (i == 10) {
            ContentResolver contentResolver9 = getContentResolver();
            a0 a0Var9 = this.b;
            OutputStream openOutputStream2 = contentResolver9.openOutputStream(a0Var9.a, a0Var9.b);
            z zVar10 = this.b.i;
            if (zVar10 != null) {
                zVar10.onPermitted(openOutputStream2);
            }
        } else if (i == 11) {
            ContentResolver contentResolver10 = getContentResolver();
            a0 a0Var10 = this.b;
            AssetFileDescriptor openTypedAssetFile = contentResolver10.openTypedAssetFile(a0Var10.a, a0Var10.c, a0Var10.d, a0Var10.h);
            z zVar11 = this.b.i;
            if (zVar11 != null) {
                zVar11.onPermitted(openTypedAssetFile);
            }
        } else if (i == 12) {
            ContentResolver contentResolver11 = getContentResolver();
            a0 a0Var11 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver11.openTypedAssetFileDescriptor(a0Var11.a, a0Var11.c, a0Var11.d);
            z zVar12 = this.b.i;
            if (zVar12 != null) {
                zVar12.onPermitted(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            ContentResolver contentResolver12 = getContentResolver();
            a0 a0Var12 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor2 = contentResolver12.openTypedAssetFileDescriptor(a0Var12.a, a0Var12.c, a0Var12.d, a0Var12.h);
            z zVar13 = this.b.i;
            if (zVar13 != null) {
                zVar13.onPermitted(openTypedAssetFileDescriptor2);
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
        z zVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            a0 a0Var = this.b;
            if (a0Var == null) {
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
            } else if (i2 == 0 && (zVar = a0Var.i) != null) {
                zVar.onRefused();
            }
            c0.b().f(String.valueOf(this.b.j));
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
            a0 c = c0.b().c(intent.getStringExtra("request_time_stamp"));
            this.b = c;
            if (c != null) {
                c();
            } else {
                finish();
            }
        }
    }
}
