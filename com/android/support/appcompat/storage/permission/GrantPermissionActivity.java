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
import com.baidu.tieba.c0;
import com.baidu.tieba.e0;
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
    public c0 b;

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
            c0 c0Var = this.b;
            int delete = contentResolver.delete(c0Var.a, c0Var.e, c0Var.f);
            b0 b0Var = this.b.i;
            if (b0Var != null) {
                b0Var.onPermitted(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            ContentResolver contentResolver2 = getContentResolver();
            c0 c0Var2 = this.b;
            int update = contentResolver2.update(c0Var2.a, c0Var2.g, c0Var2.e, c0Var2.f);
            b0 b0Var2 = this.b.i;
            if (b0Var2 != null) {
                b0Var2.onPermitted(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ContentResolver contentResolver3 = getContentResolver();
            c0 c0Var3 = this.b;
            ParcelFileDescriptor openFileDescriptor = contentResolver3.openFileDescriptor(c0Var3.a, c0Var3.b);
            b0 b0Var3 = this.b.i;
            if (b0Var3 != null) {
                b0Var3.onPermitted(openFileDescriptor);
            }
        } else if (i == 4) {
            ContentResolver contentResolver4 = getContentResolver();
            c0 c0Var4 = this.b;
            ParcelFileDescriptor openFileDescriptor2 = contentResolver4.openFileDescriptor(c0Var4.a, c0Var4.b, c0Var4.h);
            b0 b0Var4 = this.b.i;
            if (b0Var4 != null) {
                b0Var4.onPermitted(openFileDescriptor2);
            }
        } else if (i == 5) {
            ContentResolver contentResolver5 = getContentResolver();
            c0 c0Var5 = this.b;
            AssetFileDescriptor openAssetFile = contentResolver5.openAssetFile(c0Var5.a, c0Var5.b, c0Var5.h);
            b0 b0Var5 = this.b.i;
            if (b0Var5 != null) {
                b0Var5.onPermitted(openAssetFile);
            }
        } else if (i == 6) {
            ContentResolver contentResolver6 = getContentResolver();
            c0 c0Var6 = this.b;
            AssetFileDescriptor openAssetFileDescriptor = contentResolver6.openAssetFileDescriptor(c0Var6.a, c0Var6.b);
            b0 b0Var6 = this.b.i;
            if (b0Var6 != null) {
                b0Var6.onPermitted(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            ContentResolver contentResolver7 = getContentResolver();
            c0 c0Var7 = this.b;
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver7.openAssetFileDescriptor(c0Var7.a, c0Var7.b, c0Var7.h);
            b0 b0Var7 = this.b.i;
            if (b0Var7 != null) {
                b0Var7.onPermitted(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ContentResolver contentResolver8 = getContentResolver();
            c0 c0Var8 = this.b;
            ParcelFileDescriptor openFile = contentResolver8.openFile(c0Var8.a, c0Var8.b, c0Var8.h);
            b0 b0Var8 = this.b.i;
            if (b0Var8 != null) {
                b0Var8.onPermitted(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.b.a);
            b0 b0Var9 = this.b.i;
            if (b0Var9 != null) {
                b0Var9.onPermitted(openOutputStream);
            }
        } else if (i == 10) {
            ContentResolver contentResolver9 = getContentResolver();
            c0 c0Var9 = this.b;
            OutputStream openOutputStream2 = contentResolver9.openOutputStream(c0Var9.a, c0Var9.b);
            b0 b0Var10 = this.b.i;
            if (b0Var10 != null) {
                b0Var10.onPermitted(openOutputStream2);
            }
        } else if (i == 11) {
            ContentResolver contentResolver10 = getContentResolver();
            c0 c0Var10 = this.b;
            AssetFileDescriptor openTypedAssetFile = contentResolver10.openTypedAssetFile(c0Var10.a, c0Var10.c, c0Var10.d, c0Var10.h);
            b0 b0Var11 = this.b.i;
            if (b0Var11 != null) {
                b0Var11.onPermitted(openTypedAssetFile);
            }
        } else if (i == 12) {
            ContentResolver contentResolver11 = getContentResolver();
            c0 c0Var11 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver11.openTypedAssetFileDescriptor(c0Var11.a, c0Var11.c, c0Var11.d);
            b0 b0Var12 = this.b.i;
            if (b0Var12 != null) {
                b0Var12.onPermitted(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            ContentResolver contentResolver12 = getContentResolver();
            c0 c0Var12 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor2 = contentResolver12.openTypedAssetFileDescriptor(c0Var12.a, c0Var12.c, c0Var12.d, c0Var12.h);
            b0 b0Var13 = this.b.i;
            if (b0Var13 != null) {
                b0Var13.onPermitted(openTypedAssetFileDescriptor2);
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
        b0 b0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            c0 c0Var = this.b;
            if (c0Var == null) {
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
            } else if (i2 == 0 && (b0Var = c0Var.i) != null) {
                b0Var.onRefused();
            }
            e0.b().f(String.valueOf(this.b.j));
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d003e);
            Intent intent = getIntent();
            this.a = intent.getIntExtra("request_code", -1);
            c0 c = e0.b().c(intent.getStringExtra("request_time_stamp"));
            this.b = c;
            if (c != null) {
                c();
            } else {
                finish();
            }
        }
    }
}
