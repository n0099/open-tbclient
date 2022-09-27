package com.baidu.swan.apps.media.chooser.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppThumbnailAdapter;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailTouchCallback;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.DragView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.br2;
import com.baidu.tieba.cr2;
import com.baidu.tieba.d33;
import com.baidu.tieba.er2;
import com.baidu.tieba.fh3;
import com.baidu.tieba.jr2;
import com.baidu.tieba.kg3;
import com.baidu.tieba.vj1;
import com.baidu.tieba.w13;
import com.baidu.tieba.yq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, er2, jr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean J;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppThumbnailAdapter A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public String F;
    public int G;
    public ArrayList<MediaModel> H;
    public ViewPager.OnPageChangeListener I;
    public View m;
    public ViewPager n;
    public DragView o;
    public RecyclerView p;
    public View q;
    public ImageView r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public View w;
    public View x;
    public w13 y;
    public SwanAppAlbumPreviewAdapter z;

    /* loaded from: classes2.dex */
    public class a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumPreviewActivity a;

        /* renamed from: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0174a extends LinearSmoothScroller {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0174a(a aVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, displayMetrics)) == null) ? (this.a.a.getResources().getDisplayMetrics().density * 0.3f) / displayMetrics.density : invokeL.floatValue;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? super.computeScrollVectorForPosition(i) : (PointF) invokeI.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumPreviewActivity;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, recyclerView, state, i) == null) {
                C0174a c0174a = new C0174a(this, recyclerView.getContext());
                c0174a.setTargetPosition(i);
                startSmoothScroll(c0174a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends SwanAppThumbnailClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq2 c;
        public final /* synthetic */ ItemTouchHelper d;
        public final /* synthetic */ SwanAppAlbumPreviewActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity, RecyclerView recyclerView, yq2 yq2Var, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity, recyclerView, yq2Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((RecyclerView) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = swanAppAlbumPreviewActivity;
            this.c = yq2Var;
            this.d = itemTouchHelper;
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void b(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || this.e.H == null) {
                return;
            }
            MediaModel d = this.e.A.d(viewHolder.getAdapterPosition());
            int size = this.e.H.size();
            for (int i = 0; i < size; i++) {
                if (this.e.H.get(i) != null && ((MediaModel) this.e.H.get(i)).equals(d)) {
                    this.c.a(true);
                    this.e.n.setCurrentItem(i);
                    this.c.a(false);
                    return;
                }
            }
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void c(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                ArrayList<MediaModel> e = this.e.A.e();
                if (viewHolder.getLayoutPosition() < 0 || e == null || viewHolder.getLayoutPosition() == e.size()) {
                    return;
                }
                this.d.startDrag(viewHolder);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumPreviewActivity a;

        public c(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumPreviewActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.z.q();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.C = i;
                this.a.X();
                this.a.T();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ SwanAppAlbumPreviewActivity b;

        public d(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAlbumPreviewActivity;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 0) {
                    this.b.p.smoothScrollToPosition(this.a - 1);
                } else {
                    this.b.p.smoothScrollToPosition(this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumPreviewActivity a;

        public e(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumPreviewActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.E = false;
                SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = this.a;
                swanAppAlbumPreviewActivity.D = !swanAppAlbumPreviewActivity.D;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumPreviewActivity a;

        public f(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAlbumPreviewActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.E = false;
                SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = this.a;
                swanAppAlbumPreviewActivity.D = !swanAppAlbumPreviewActivity.D;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-554636937, "Lcom/baidu/swan/apps/media/chooser/activity/SwanAppAlbumPreviewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-554636937, "Lcom/baidu/swan/apps/media/chooser/activity/SwanAppAlbumPreviewActivity;");
                return;
            }
        }
        J = vj1.a;
    }

    public SwanAppAlbumPreviewActivity() {
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
        this.B = true;
        this.D = true;
        this.E = false;
        this.G = 200;
        this.I = new c(this);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TextUtils.equals(this.F, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.u.setVisibility(8);
            this.w.setVisibility(8);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("isRefresh", true);
            setResult(-1, intent);
        }
    }

    public final yq2 O(ViewPager viewPager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewPager)) == null) {
            yq2 yq2Var = new yq2(viewPager.getContext());
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, yq2Var);
            } catch (Exception e2) {
                if (J) {
                    e2.printStackTrace();
                }
            }
            return yq2Var;
        }
        return (yq2) invokeL.objValue;
    }

    public final String P(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaModel)) == null) ? String.valueOf(cr2.c(mediaModel) + 1) : (String) invokeL.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0921cf);
            this.q = findViewById(R.id.obfuscated_res_0x7f09025d);
            a aVar = new a(this, this);
            aVar.setOrientation(0);
            this.p.setLayoutManager(aVar);
            SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
            this.A = swanAppThumbnailAdapter;
            this.p.setAdapter(swanAppThumbnailAdapter);
            this.A.i(cr2.e() == null ? null : cr2.e());
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.A));
            itemTouchHelper.attachToRecyclerView(this.p);
            yq2 O = O(this.n);
            RecyclerView recyclerView = this.p;
            recyclerView.addOnItemTouchListener(new b(this, recyclerView, O, itemTouchHelper));
            Y();
            X();
        }
    }

    public final void R() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m = findViewById(R.id.obfuscated_res_0x7f090258);
            DragView dragView = (DragView) findViewById(R.id.obfuscated_res_0x7f090853);
            this.o = dragView;
            dragView.setOnCloseListener(this);
            this.o.setBackgroundColor(-16777216);
            this.n = (ViewPager) findViewById(R.id.obfuscated_res_0x7f090261);
            this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f09025f);
            this.t = findViewById(R.id.obfuscated_res_0x7f090256);
            this.s = findViewById(R.id.obfuscated_res_0x7f090260);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f090259);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09025e);
            this.w = findViewById(R.id.obfuscated_res_0x7f090257);
            this.x = findViewById(R.id.obfuscated_res_0x7f09025a);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.n.setOnPageChangeListener(this.I);
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.H);
            this.z = swanAppAlbumPreviewAdapter;
            this.n.setAdapter(swanAppAlbumPreviewAdapter);
            this.z.v(this);
            this.n.setCurrentItem(this.C);
            this.s.setOnClickListener(this);
            this.u.setBackgroundResource(R.drawable.obfuscated_res_0x7f081187);
            this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a9c));
            if (cr2.d() != 0) {
                string = getString(R.string.obfuscated_res_0x7f0f12c3) + "(" + cr2.d() + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f12c3);
            }
            this.u.setText(string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            int abs = Math.abs(i);
            if (abs >= 0) {
                float f2 = abs;
                if (f2 < 300.0f) {
                    i2 = (int) (255.0f - ((f2 / 300.0f) * 20.0f));
                    this.m.getBackground().mutate().setAlpha(i2 >= 0 ? i2 : 0);
                }
            }
            float f3 = abs;
            if (f3 >= 300.0f) {
                float f4 = 235;
                i2 = (int) (f4 - (((f3 - 300.0f) / 900.0f) * f4));
            } else {
                i2 = 0;
            }
            this.m.getBackground().mutate().setAlpha(i2 >= 0 ? i2 : 0);
        }
    }

    public final void T() {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (arrayList = this.H) == null) {
            return;
        }
        MediaModel mediaModel = this.C < arrayList.size() ? this.H.get(this.C) : null;
        if (mediaModel == null) {
            return;
        }
        if (cr2.g(mediaModel)) {
            this.v.setVisibility(0);
            this.v.setText(P(this.H.get(this.C)));
            this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f081188);
            return;
        }
        this.v.setVisibility(8);
        if (br2.f(br2.d, mediaModel)) {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f08118a);
        } else {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f081189);
        }
    }

    public final void U(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            float f2 = i == 0 ? 0.0f : 1.0f;
            View view2 = this.w;
            if (view2 != null) {
                view2.setAlpha(1.0f - f2);
            }
            View view3 = this.x;
            if (view3 != null) {
                view3.setAlpha(1.0f - f2);
            }
        }
    }

    public void V(Drawable drawable) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) || (view2 = this.m) == null) {
            return;
        }
        view2.setBackground(drawable);
    }

    @TargetApi(19)
    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
            window.setAttributes(attributes);
        }
    }

    public final void X() {
        int h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.A == null || this.C >= this.H.size() || (h = this.A.h(this.H.get(this.C))) < 0) {
            return;
        }
        int i = h + 1;
        if (i < this.A.getItemCount()) {
            this.p.smoothScrollToPosition(i);
        } else {
            this.p.smoothScrollToPosition(h);
        }
        this.p.postDelayed(new d(this, h), 300L);
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ArrayList<MediaModel> e2 = cr2.e();
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706cd);
            if (e2 != null && e2.size() > 0) {
                this.p.setVisibility(0);
                this.q.setVisibility(0);
                layoutParams.height = dimensionPixelSize;
                return;
            }
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706b7)) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706d8);
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            U(i);
            S(i);
            if (i != 0 && this.B) {
                V(new ColorDrawable(Color.parseColor("#1a1a1a")));
                this.o.setBackground(new ColorDrawable(0));
                SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.z;
                if (swanAppAlbumPreviewAdapter != null) {
                    swanAppAlbumPreviewAdapter.u(this.C, 0);
                }
                this.B = false;
            }
            if (i == 0) {
                V(new ColorDrawable(0));
                this.o.setBackgroundColor(-16777216);
                SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter2 = this.z;
                if (swanAppAlbumPreviewAdapter2 != null) {
                    swanAppAlbumPreviewAdapter2.u(this.C, -16777216);
                }
                this.B = true;
            }
        }
    }

    @Override // com.baidu.tieba.er2
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.D) {
            this.E = true;
            float y = this.x.getY();
            float y2 = this.w.getY();
            View view2 = this.x;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "y", y, y - view2.getHeight());
            ofFloat.setDuration(this.G);
            ofFloat.addListener(new e(this));
            ofFloat.start();
            View view3 = this.w;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "y", y2, y2 + view3.getHeight());
            ofFloat2.setDuration(this.G);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.tieba.er2
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.D) {
            return;
        }
        this.E = true;
        float y = this.x.getY();
        float y2 = this.w.getY();
        View view2 = this.x;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "y", y, y + view2.getHeight());
        ofFloat.setDuration(this.G);
        ofFloat.addListener(new f(this));
        ofFloat.start();
        View view3 = this.w;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "y", y2, y2 - view3.getHeight());
        ofFloat2.setDuration(this.G);
        ofFloat2.start();
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.tieba.er2
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!this.E && this.D) {
                c();
            } else if (this.E) {
            } else {
                e();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ArrayList<MediaModel> arrayList;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            if (view2 == this.t) {
                N();
                finish();
                return;
            }
            ArrayList<MediaModel> arrayList2 = this.H;
            if (arrayList2 == null || this.C >= arrayList2.size()) {
                return;
            }
            MediaModel mediaModel = this.H.get(this.C);
            if (view2 == this.s) {
                if (cr2.f(mediaModel)) {
                    this.A.notifyItemRemoved(cr2.c(mediaModel));
                    cr2.h(mediaModel);
                    if (cr2.d() == 0) {
                        this.A.i(null);
                    }
                    this.v.setVisibility(8);
                    this.r.setImageResource(R.drawable.obfuscated_res_0x7f081189);
                    if (cr2.d() > 0) {
                        string = getString(R.string.obfuscated_res_0x7f0f12c3) + "(" + cr2.d() + SmallTailInfo.EMOTION_SUFFIX;
                    } else {
                        string = getString(R.string.obfuscated_res_0x7f0f12c3);
                    }
                    this.u.setText(string);
                    Y();
                    return;
                }
                int d2 = cr2.d();
                if (d2 == br2.c) {
                    br2.j(br2.d);
                } else if (d2 > 0 && TextUtils.equals(br2.d, "single") && !TextUtils.equals(cr2.b(), mediaModel.getType())) {
                    d33.f(this, R.string.obfuscated_res_0x7f0f12b2).G();
                } else if (mediaModel.getSize() > 52428800 && TextUtils.equals(mediaModel.getType(), "image")) {
                    d33.f(this, R.string.obfuscated_res_0x7f0f12b1).G();
                } else {
                    int d3 = cr2.d();
                    this.A.notifyItemInserted(d3);
                    cr2.i(mediaModel);
                    if (this.A.e() == null) {
                        this.A.i(cr2.e());
                    }
                    this.p.smoothScrollToPosition(d3);
                    this.v.setVisibility(0);
                    this.v.setText(P(mediaModel));
                    this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f081188);
                    this.u.setText(getString(R.string.obfuscated_res_0x7f0f12c3) + "(" + cr2.d() + SmallTailInfo.EMOTION_SUFFIX);
                    this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a9c));
                    Y();
                }
            } else if (view2 == this.u) {
                if (cr2.d() == 0 && (arrayList = this.H) != null && arrayList.size() > 0 && this.C < this.H.size()) {
                    cr2.i(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", br2.e);
                bundle.putString("swanAppId", br2.f);
                bundle.putParcelableArrayList("mediaModels", cr2.e());
                bundle.putString("swanTmpPath", br2.j);
                br2.g(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            finish();
            overridePendingTransition(R.anim.obfuscated_res_0x7f01013b, R.anim.obfuscated_res_0x7f01001c);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.bh4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            int c0 = fh3.c0(this);
            super.onCreate(bundle);
            fh3.g(this, c0);
            W();
            w13 w13Var = new w13(this);
            this.y = w13Var;
            w13Var.b(false);
            getWindow().setFlags(1024, 1024);
            if (!Fresco.hasBeenInitialized()) {
                Fresco.initialize(getApplicationContext());
            }
            setContentView(R.layout.obfuscated_res_0x7f0d0827);
            if (getIntent() != null) {
                Bundle e2 = kg3.e(getIntent(), "launchParams");
                this.C = kg3.f(e2, "previewPosition", 0);
                String g = kg3.g(e2, "previewFrom");
                this.F = g;
                if (TextUtils.equals(g, "bottomPreview")) {
                    ArrayList<MediaModel> arrayList = new ArrayList<>();
                    this.H = arrayList;
                    arrayList.addAll(cr2.e());
                } else if (TextUtils.equals(this.F, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                    this.H = e2 == null ? null : e2.getParcelableArrayList("mediaModels");
                } else {
                    this.H = br2.c();
                }
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
            }
            R();
            T();
            Q();
            M();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.z;
            if (swanAppAlbumPreviewAdapter != null) {
                swanAppAlbumPreviewAdapter.k();
                this.z = null;
            }
            this.A = null;
            this.y = null;
            if (this.H != null) {
                this.H = null;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, keyEvent)) == null) {
            if (i == 4) {
                N();
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.jr2
    public void onMove(int i, int i2) {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) || (arrayList = this.H) == null || this.C >= arrayList.size()) {
            return;
        }
        this.v.setText(P(this.H.get(this.C)));
    }
}
