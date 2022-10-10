package com.baidu.swan.apps.media.chooser.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.br2;
import com.baidu.tieba.ch3;
import com.baidu.tieba.cr2;
import com.baidu.tieba.fg3;
import com.baidu.tieba.fh3;
import com.baidu.tieba.ir2;
import com.baidu.tieba.kg3;
import com.baidu.tieba.l02;
import com.baidu.tieba.lr2;
import com.baidu.tieba.mr2;
import com.baidu.tieba.wq2;
import com.baidu.tieba.xq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<lr2> A;
    public Handler B;
    public AdapterView.OnItemClickListener C;
    public ActivityResultDispatcher m;
    public GridView n;
    public wq2 o;
    public TextView p;
    public TextView q;
    public TextView r;
    public RelativeLayout s;
    public TextView t;
    public View u;
    public View v;
    public HeightListView w;
    public LoadingLayout x;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumActivity a;

        public a(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (!this.a.y || this.a.z) {
                    return true;
                }
                this.a.V();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ir2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumActivity a;

        public b(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumActivity;
        }

        @Override // com.baidu.tieba.ir2
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.O();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumActivity a;

        public c(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.y = false;
                this.a.z = false;
                this.a.u.setVisibility(8);
                this.a.v.setVisibility(8);
                Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081193);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.a.p.setCompoundDrawables(null, null, drawable, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumActivity a;

        public d(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.y = true;
                this.a.z = false;
                Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081181);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.a.p.setCompoundDrawables(null, null, drawable, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumActivity a;

        public e(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.y && !this.a.z) {
                    this.a.V();
                }
                this.a.p.setText(((lr2) this.a.A.get(i)).c());
                ArrayList<MediaModel> arrayList = ((lr2) this.a.A.get(i)).d;
                this.a.o.x(arrayList);
                if (arrayList.size() == 0) {
                    this.a.s.setVisibility(8);
                } else {
                    this.a.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<SwanAppAlbumActivity> a;

        public f(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(swanAppAlbumActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                SwanAppAlbumActivity swanAppAlbumActivity = this.a.get();
                if (swanAppAlbumActivity == null || swanAppAlbumActivity.isFinishing() || message.what != 0) {
                    return;
                }
                l02.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (obj instanceof ArrayList) {
                    swanAppAlbumActivity.U(obj);
                }
            }
        }
    }

    public SwanAppAlbumActivity() {
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
        this.y = false;
        this.z = false;
        this.A = new ArrayList<>();
        this.C = new e(this);
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (cr2.d() > 0) {
                this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a9d));
                this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a8e));
                this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f12b4, Integer.valueOf(cr2.d())));
                return;
            }
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a9e));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a8f));
            this.q.setText(getString(R.string.obfuscated_res_0x7f0f12c4));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getIntent() == null) {
            return;
        }
        Bundle e2 = kg3.e(getIntent(), "launchParams");
        br2.b = kg3.g(e2, "launchType");
        br2.h = kg3.c(e2, "isShowCamera", true);
        br2.i = kg3.c(e2, "isFrontCamera", false);
        br2.g = kg3.f(e2, "maxDuration", 60);
        br2.c = kg3.f(e2, "count", 9);
        String g = kg3.g(e2, "mode");
        br2.e = kg3.c(e2, "compressed", true);
        br2.f = kg3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            br2.d = g;
        }
        br2.j = kg3.g(e2, "swanTmpPath");
        int i = br2.c;
        if (i < 1 || i > 9) {
            br2.c = 9;
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.w.setAdapter((ListAdapter) new xq2(this, br2.b, this.A));
            this.w.setOnItemClickListener(this.C);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.B = new f(this);
            this.x.b(true);
            fg3.j(new mr2(br2.b, this.B), "loadAlbumTask");
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wq2 wq2Var = new wq2(this);
            this.o = wq2Var;
            this.n.setAdapter((ListAdapter) wq2Var);
            this.o.x(this.A.get(0).d);
            this.o.z(new b(this));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f09023d);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09024c);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090262);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090237);
            this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090236);
            this.u = findViewById(R.id.obfuscated_res_0x7f090253);
            this.v = findViewById(R.id.obfuscated_res_0x7f090252);
            this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f090251);
            this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f09023c);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090248);
            this.w.setListViewHeight(ch3.f(this, 400.0f));
            this.p.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.u.setOnTouchListener(new a(this));
            this.s.setVisibility(0);
            this.p.setText(br2.b(this, br2.b));
        }
    }

    public final void U(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            this.x.b(false);
            ArrayList<lr2> arrayList = (ArrayList) obj;
            this.A = arrayList;
            if (arrayList.size() > 0 && this.A.get(0) != null) {
                if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                    this.s.setVisibility(8);
                }
                Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f081193);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.p.setCompoundDrawables(null, null, drawable, null);
                this.p.setCompoundDrawablePadding(ch3.f(this, 4.0f));
            } else {
                this.s.setVisibility(8);
            }
            this.q.setVisibility(0);
            O();
            Q();
            S();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.y) {
            this.z = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f01013a);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.v.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new c(this));
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.y) {
            return;
        }
        this.u.setVisibility(0);
        this.v.setVisibility(0);
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010139);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d(this));
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.finish();
            overridePendingTransition(0, R.anim.obfuscated_res_0x7f010141);
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (ActivityResultDispatcher) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) || getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 32770 && i2 == -1) {
            if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                wq2 wq2Var = this.o;
                if (wq2Var != null) {
                    wq2Var.notifyDataSetChanged();
                }
                O();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            if (view2 == this.p) {
                ArrayList<lr2> arrayList = this.A;
                if (arrayList == null || arrayList.size() <= 1 || this.z) {
                    return;
                }
                if (this.y) {
                    V();
                } else {
                    W();
                }
            } else if (view2 == this.q) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", br2.e);
                bundle.putString("swanAppId", br2.f);
                bundle.putParcelableArrayList("mediaModels", cr2.e());
                bundle.putString("swanTmpPath", br2.j);
                br2.g(this, bundle);
            } else if (view2 == this.t) {
                finish();
            } else if (view2 != this.r || cr2.d() <= 0) {
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString("previewFrom", "bottomPreview");
                bundle2.putInt("previewPosition", 0);
                br2.k(this, bundle2);
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.bh4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            int c0 = fh3.c0(this);
            super.onCreate(bundle);
            this.m = new ActivityResultDispatcher(this, 1);
            fh3.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d0823);
            ch3.a(this);
            P();
            T();
            R();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            Handler handler = this.B;
            if (handler != null) {
                handler.removeMessages(0);
                this.B = null;
            }
            cr2.a();
            br2.a();
        }
    }
}
