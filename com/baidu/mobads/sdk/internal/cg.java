package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class cg implements Observer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "APKParser";
    public static final String g = "__xadsdk_downloaded__version__";
    public static final String h = "version";
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public URL c;
    public String d;
    public final bv e;
    public a f;
    public SharedPreferences i;
    public SharedPreferences.OnSharedPreferenceChangeListener j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(bv bvVar);

        void b(bv bvVar);
    }

    public cg(Context context, String str, bv bvVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, bvVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.j = new ch(this);
        this.d = str;
        this.e = bvVar;
        a(context, aVar);
    }

    public cg(Context context, URL url, bv bvVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, url, bvVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.j = new ch(this);
        this.c = url;
        this.e = bvVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, aVar) == null) {
            this.b = context;
            this.f = aVar;
            SharedPreferences sharedPreferences = context.getSharedPreferences(g, 0);
            this.i = sharedPreferences;
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.j);
        }
    }

    public void a(String str, String str2) {
        URL url;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (this.d != null) {
                url = new URL(this.d);
            } else {
                url = this.c;
            }
            al alVar = new al(this.b, url, str, str2, false);
            alVar.addObserver(this);
            alVar.a();
            SharedPreferences.Editor edit = this.i.edit();
            edit.putString("version", this.e.toString());
            edit.apply();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observable, obj) == null) {
            u uVar = (u) observable;
            if (uVar.l() == u.a.e) {
                this.f.a(new bv(this.e, uVar.g(), Boolean.TRUE));
            }
            if (uVar.l() == u.a.f) {
                this.f.b(new bv(this.e, uVar.g(), Boolean.FALSE));
            }
        }
    }
}
