package com.android.support.appcompat.storage.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.y;
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
    public x b;

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

    public final void a(int i) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b == null) {
            return;
        }
        if (i == 1) {
            ContentResolver contentResolver = getContentResolver();
            x xVar = this.b;
            int delete = contentResolver.delete(xVar.a, xVar.e, xVar.f);
            w wVar = this.b.i;
            if (wVar != null) {
                wVar.a(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            ContentResolver contentResolver2 = getContentResolver();
            x xVar2 = this.b;
            int update = contentResolver2.update(xVar2.a, xVar2.g, xVar2.e, xVar2.f);
            w wVar2 = this.b.i;
            if (wVar2 != null) {
                wVar2.a(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ContentResolver contentResolver3 = getContentResolver();
            x xVar3 = this.b;
            ParcelFileDescriptor openFileDescriptor = contentResolver3.openFileDescriptor(xVar3.a, xVar3.b);
            w wVar3 = this.b.i;
            if (wVar3 != null) {
                wVar3.a(openFileDescriptor);
            }
        } else if (i == 4) {
            ContentResolver contentResolver4 = getContentResolver();
            x xVar4 = this.b;
            ParcelFileDescriptor openFileDescriptor2 = contentResolver4.openFileDescriptor(xVar4.a, xVar4.b, xVar4.h);
            w wVar4 = this.b.i;
            if (wVar4 != null) {
                wVar4.a(openFileDescriptor2);
            }
        } else if (i == 5) {
            ContentResolver contentResolver5 = getContentResolver();
            x xVar5 = this.b;
            AssetFileDescriptor openAssetFile = contentResolver5.openAssetFile(xVar5.a, xVar5.b, xVar5.h);
            w wVar5 = this.b.i;
            if (wVar5 != null) {
                wVar5.a(openAssetFile);
            }
        } else if (i == 6) {
            ContentResolver contentResolver6 = getContentResolver();
            x xVar6 = this.b;
            AssetFileDescriptor openAssetFileDescriptor = contentResolver6.openAssetFileDescriptor(xVar6.a, xVar6.b);
            w wVar6 = this.b.i;
            if (wVar6 != null) {
                wVar6.a(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            ContentResolver contentResolver7 = getContentResolver();
            x xVar7 = this.b;
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver7.openAssetFileDescriptor(xVar7.a, xVar7.b, xVar7.h);
            w wVar7 = this.b.i;
            if (wVar7 != null) {
                wVar7.a(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ContentResolver contentResolver8 = getContentResolver();
            x xVar8 = this.b;
            ParcelFileDescriptor openFile = contentResolver8.openFile(xVar8.a, xVar8.b, xVar8.h);
            w wVar8 = this.b.i;
            if (wVar8 != null) {
                wVar8.a(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.b.a);
            w wVar9 = this.b.i;
            if (wVar9 != null) {
                wVar9.a(openOutputStream);
            }
        } else if (i == 10) {
            ContentResolver contentResolver9 = getContentResolver();
            x xVar9 = this.b;
            OutputStream openOutputStream2 = contentResolver9.openOutputStream(xVar9.a, xVar9.b);
            w wVar10 = this.b.i;
            if (wVar10 != null) {
                wVar10.a(openOutputStream2);
            }
        } else if (i == 11) {
            ContentResolver contentResolver10 = getContentResolver();
            x xVar10 = this.b;
            AssetFileDescriptor openTypedAssetFile = contentResolver10.openTypedAssetFile(xVar10.a, xVar10.c, xVar10.d, xVar10.h);
            w wVar11 = this.b.i;
            if (wVar11 != null) {
                wVar11.a(openTypedAssetFile);
            }
        } else if (i == 12) {
            ContentResolver contentResolver11 = getContentResolver();
            x xVar11 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver11.openTypedAssetFileDescriptor(xVar11.a, xVar11.c, xVar11.d);
            w wVar12 = this.b.i;
            if (wVar12 != null) {
                wVar12.a(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            ContentResolver contentResolver12 = getContentResolver();
            x xVar12 = this.b;
            AssetFileDescriptor openTypedAssetFileDescriptor2 = contentResolver12.openTypedAssetFileDescriptor(xVar12.a, xVar12.c, xVar12.d, xVar12.h);
            w wVar13 = this.b.i;
            if (wVar13 != null) {
                wVar13.a(openTypedAssetFileDescriptor2);
            }
        }
    }

    public final void b() {
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
        w wVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            x xVar = this.b;
            if (xVar == null) {
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
            } else if (i2 == 0 && (wVar = xVar.i) != null) {
                wVar.b();
            }
            y.a().c(String.valueOf(this.b.j));
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
            x b = y.a().b(intent.getStringExtra("request_time_stamp"));
            this.b = b;
            if (b != null) {
                b();
            } else {
                finish();
            }
        }
    }
}
