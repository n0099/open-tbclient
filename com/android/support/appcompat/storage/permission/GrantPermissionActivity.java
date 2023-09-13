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
import com.baidu.tieba.b0;
import com.baidu.tieba.d0;
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
    public b0 b;

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
            b0 b0Var = this.b;
            int delete = contentResolver.delete(b0Var.a, b0Var.e, b0Var.f);
            a0 a0Var = this.b.i;
            if (a0Var != null) {
                a0Var.onPermitted(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            ContentResolver contentResolver2 = getContentResolver();
            b0 b0Var2 = this.b;
            int update = contentResolver2.update(b0Var2.a, b0Var2.g, b0Var2.e, b0Var2.f);
            a0 a0Var2 = this.b.i;
            if (a0Var2 != null) {
                a0Var2.onPermitted(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ContentResolver contentResolver3 = getContentResolver();
            b0 b0Var3 = this.b;
            ParcelFileDescriptor openFileDescriptor = contentResolver3.openFileDescriptor(b0Var3.a, b0Var3.b);
            a0 a0Var3 = this.b.i;
            if (a0Var3 != null) {
                a0Var3.onPermitted(openFileDescriptor);
            }
        } else if (i == 4) {
            ContentResolver contentResolver4 = getContentResolver();
            b0 b0Var4 = this.b;
            ParcelFileDescriptor openFileDescriptor2 = contentResolver4.openFileDescriptor(b0Var4.a, b0Var4.b, b0Var4.h);
            a0 a0Var4 = this.b.i;
            if (a0Var4 != null) {
                a0Var4.onPermitted(openFileDescriptor2);
            }
        } else if (i == 5) {
            ContentResolver contentResolver5 = getContentResolver();
            b0 b0Var5 = this.b;
            AssetFileDescriptor openAssetFile = contentResolver5.openAssetFile(b0Var5.a, b0Var5.b, b0Var5.h);
            a0 a0Var5 = this.b.i;
            if (a0Var5 != null) {
                a0Var5.onPermitted(openAssetFile);
            }
        } else if (i == 6) {
            ContentResolver contentResolver6 = getContentResolver();
            b0 b0Var6 = this.b;
            AssetFileDescriptor openAssetFileDescriptor = contentResolver6.openAssetFileDescriptor(b0Var6.a, b0Var6.b);
            a0 a0Var6 = this.b.i;
            if (a0Var6 != null) {
                a0Var6.onPermitted(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            ContentResolver contentResolver7 = getContentResolver();
            b0 b0Var7 = this.b;
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver7.openAssetFileDescriptor(b0Var7.a, b0Var7.b, b0Var7.h);
            a0 a0Var7 = this.b.i;
            if (a0Var7 != null) {
                a0Var7.onPermitted(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ContentResolver contentResolver8 = getContentResolver();
            b0 b0Var8 = this.b;
            ParcelFileDescriptor openFile = contentResolver8.openFile(b0Var8.a, b0Var8.b, b0Var8.h);
            a0 a0Var8 = this.b.i;
            if (a0Var8 != null) {
                a0Var8.onPermitted(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.b.a);
            a0 a0Var9 = this.b.i;
            if (a0Var9 != null) {
                a0Var9.onPermitted(openOutputStream);
            }
        } else if (i == 10) {
            ContentResolver contentResolver9 = getContentResolver();
            b0 b0Var9 = this.b;
            OutputStream openOutputStream2 = contentResolver9.openOutputStream(b0Var9.a, b0Var9.b);
            a0 a0Var10 = this.b.i;
            if (a0Var10 != null) {
                a0Var10.onPermitted(openOutputStream2);
            }
        } else if (i == 11) {
            ContentResolver contentResolver10 = getContentResolver();
            b0 b0Var10 = this.b;
            AssetFileDescriptor openTypedAssetFile = contentResolver10.openTypedAssetFile(b0Var10.a, b0Var10.c, b0Var10.d, b0Var10.h);
            a0 a0Var11 = this.b.i;
            if (a0Var11 != null) {
                a0Var11.onPermitted(openTypedAssetFile);
            }
        } else if (i == 12) {
            ContentResolver contentResolver11 = getContentResolver();
            b0 b0Var11 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver11.openTypedAssetFileDescriptor(b0Var11.a, b0Var11.c, b0Var11.d);
            a0 a0Var12 = this.b.i;
            if (a0Var12 != null) {
                a0Var12.onPermitted(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            ContentResolver contentResolver12 = getContentResolver();
            b0 b0Var12 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor2 = contentResolver12.openTypedAssetFileDescriptor(b0Var12.a, b0Var12.c, b0Var12.d, b0Var12.h);
            a0 a0Var13 = this.b.i;
            if (a0Var13 != null) {
                a0Var13.onPermitted(openTypedAssetFileDescriptor2);
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
        a0 a0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            b0 b0Var = this.b;
            if (b0Var == null) {
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
            } else if (i2 == 0 && (a0Var = b0Var.i) != null) {
                a0Var.onRefused();
            }
            d0.b().f(String.valueOf(this.b.j));
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
            b0 c = d0.b().c(intent.getStringExtra("request_time_stamp"));
            this.b = c;
            if (c != null) {
                c();
            } else {
                finish();
            }
        }
    }
}
