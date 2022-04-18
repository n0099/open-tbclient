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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.protobuf.CodedInputStream;
import com.kuaishou.weapon.un.w0;
import com.repackage.ao2;
import com.repackage.b03;
import com.repackage.co2;
import com.repackage.de3;
import com.repackage.ho2;
import com.repackage.id3;
import com.repackage.tg1;
import com.repackage.uy2;
import com.repackage.wn2;
import com.repackage.zn2;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, co2, ho2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAlbumPreviewAdapter mAdapter;
    public boolean mAnimation;
    public View mBackTv;
    public boolean mBarShowing;
    public View mBottomView;
    public TextView mDoneTv;
    public boolean mDragActionOver;
    public DragView mDragView;
    public int mDuration;
    public String mFrom;
    public int mIndex;
    public View mLineView;
    public ArrayList<MediaModel> mList;
    public View mPhotoHeader;
    public View mRootView;
    public ImageView mSelectImg;
    public TextView mSelectNumTv;
    public View mSelectView;
    public SwanAppThumbnailAdapter mThumbnailAdapter;
    public RecyclerView mThumbnailView;
    public uy2 mTintManager;
    public ViewPager mViewPager;
    public ViewPager.OnPageChangeListener pageChangeListener;

    /* loaded from: classes2.dex */
    public class a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAlbumPreviewActivity a;

        /* renamed from: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0159a extends LinearSmoothScroller {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0159a(a aVar, Context context) {
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
                C0159a c0159a = new C0159a(this, recyclerView.getContext());
                c0159a.setTargetPosition(i);
                startSmoothScroll(c0159a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends SwanAppThumbnailClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn2 c;
        public final /* synthetic */ ItemTouchHelper d;
        public final /* synthetic */ SwanAppAlbumPreviewActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity, RecyclerView recyclerView, wn2 wn2Var, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity, recyclerView, wn2Var, itemTouchHelper};
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
            this.c = wn2Var;
            this.d = itemTouchHelper;
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void b(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || this.e.mList == null) {
                return;
            }
            MediaModel d = this.e.mThumbnailAdapter.d(viewHolder.getAdapterPosition());
            int size = this.e.mList.size();
            for (int i = 0; i < size; i++) {
                if (this.e.mList.get(i) != null && ((MediaModel) this.e.mList.get(i)).equals(d)) {
                    this.c.a(true);
                    this.e.mViewPager.setCurrentItem(i);
                    this.c.a(false);
                    return;
                }
            }
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void c(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                ArrayList<MediaModel> e = this.e.mThumbnailAdapter.e();
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
                this.a.mAdapter.r();
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
                this.a.mIndex = i;
                this.a.smoothScrollToPosition();
                this.a.setBottomSelectBtn();
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
                    this.b.mThumbnailView.smoothScrollToPosition(this.a - 1);
                } else {
                    this.b.mThumbnailView.smoothScrollToPosition(this.a);
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
                this.a.mAnimation = false;
                SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = this.a;
                swanAppAlbumPreviewActivity.mBarShowing = !swanAppAlbumPreviewActivity.mBarShowing;
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
                this.a.mAnimation = false;
                SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = this.a;
                swanAppAlbumPreviewActivity.mBarShowing = !swanAppAlbumPreviewActivity.mBarShowing;
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
        DEBUG = tg1.a;
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
        this.mDragActionOver = true;
        this.mBarShowing = true;
        this.mAnimation = false;
        this.mDuration = 200;
        this.pageChangeListener = new c(this);
    }

    private void adjustViewStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.mDoneTv.setVisibility(8);
            this.mBottomView.setVisibility(8);
        }
    }

    private void backDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("isRefresh", true);
            setResult(-1, intent);
        }
    }

    private wn2 getNoDurationScroller(ViewPager viewPager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, viewPager)) == null) {
            wn2 wn2Var = new wn2(viewPager.getContext());
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, wn2Var);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            return wn2Var;
        }
        return (wn2) invokeL.objValue;
    }

    private String getSelectNum(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, mediaModel)) == null) ? String.valueOf(ao2.c(mediaModel) + 1) : (String) invokeL.objValue;
    }

    private void initBottomThumbnailView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mThumbnailView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091fd1);
            this.mLineView = findViewById(R.id.obfuscated_res_0x7f090258);
            a aVar = new a(this, this);
            aVar.setOrientation(0);
            this.mThumbnailView.setLayoutManager(aVar);
            SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
            this.mThumbnailAdapter = swanAppThumbnailAdapter;
            this.mThumbnailView.setAdapter(swanAppThumbnailAdapter);
            this.mThumbnailAdapter.i(ao2.e() == null ? null : ao2.e());
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.mThumbnailAdapter));
            itemTouchHelper.attachToRecyclerView(this.mThumbnailView);
            wn2 noDurationScroller = getNoDurationScroller(this.mViewPager);
            RecyclerView recyclerView = this.mThumbnailView;
            recyclerView.addOnItemTouchListener(new b(this, recyclerView, noDurationScroller, itemTouchHelper));
            updateThumbnailView();
            smoothScrollToPosition();
        }
    }

    private void initView() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f090253);
            DragView dragView = (DragView) findViewById(R.id.obfuscated_res_0x7f09083d);
            this.mDragView = dragView;
            dragView.setOnCloseListener(this);
            this.mDragView.setBackgroundColor(-16777216);
            this.mViewPager = (ViewPager) findViewById(R.id.obfuscated_res_0x7f09025c);
            this.mSelectImg = (ImageView) findViewById(R.id.obfuscated_res_0x7f09025a);
            this.mBackTv = findViewById(R.id.obfuscated_res_0x7f090251);
            this.mSelectView = findViewById(R.id.obfuscated_res_0x7f09025b);
            this.mDoneTv = (TextView) findViewById(R.id.obfuscated_res_0x7f090254);
            this.mSelectNumTv = (TextView) findViewById(R.id.obfuscated_res_0x7f090259);
            this.mBottomView = findViewById(R.id.obfuscated_res_0x7f090252);
            this.mPhotoHeader = findViewById(R.id.obfuscated_res_0x7f090255);
            this.mBackTv.setOnClickListener(this);
            this.mDoneTv.setOnClickListener(this);
            this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.mList);
            this.mAdapter = swanAppAlbumPreviewAdapter;
            this.mViewPager.setAdapter(swanAppAlbumPreviewAdapter);
            this.mAdapter.w(this);
            this.mViewPager.setCurrentItem(this.mIndex);
            this.mSelectView.setOnClickListener(this);
            this.mDoneTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081154);
            this.mDoneTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a75));
            if (ao2.d() != 0) {
                string = getString(R.string.obfuscated_res_0x7f0f127c) + "(" + ao2.d() + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f127c);
            }
            this.mDoneTv.setText(string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBackGroundAlpha(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i) == null) {
            int abs = Math.abs(i);
            if (abs >= 0) {
                float f2 = abs;
                if (f2 < 300.0f) {
                    i2 = (int) (255.0f - ((f2 / 300.0f) * 20.0f));
                    this.mRootView.getBackground().mutate().setAlpha(i2 >= 0 ? i2 : 0);
                }
            }
            float f3 = abs;
            if (f3 >= 300.0f) {
                float f4 = (float) w0.k0;
                i2 = (int) (f4 - (((f3 - 300.0f) / 900.0f) * f4));
            } else {
                i2 = 0;
            }
            this.mRootView.getBackground().mutate().setAlpha(i2 >= 0 ? i2 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottomSelectBtn() {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (arrayList = this.mList) == null) {
            return;
        }
        MediaModel mediaModel = this.mIndex < arrayList.size() ? this.mList.get(this.mIndex) : null;
        if (mediaModel == null) {
            return;
        }
        if (ao2.g(mediaModel)) {
            this.mSelectNumTv.setVisibility(0);
            this.mSelectNumTv.setText(getSelectNum(this.mList.get(this.mIndex)));
            this.mSelectNumTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081155);
            return;
        }
        this.mSelectNumTv.setVisibility(8);
        if (zn2.f(zn2.d, mediaModel)) {
            this.mSelectImg.setImageResource(R.drawable.obfuscated_res_0x7f081157);
        } else {
            this.mSelectImg.setImageResource(R.drawable.obfuscated_res_0x7f081156);
        }
    }

    private void setOtherViewAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i) == null) {
            float f2 = i == 0 ? 0.0f : 1.0f;
            View view2 = this.mBottomView;
            if (view2 != null) {
                view2.setAlpha(1.0f - f2);
            }
            View view3 = this.mPhotoHeader;
            if (view3 != null) {
                view3.setAlpha(1.0f - f2);
            }
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollToPosition() {
        int h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || this.mThumbnailAdapter == null || this.mIndex >= this.mList.size() || (h = this.mThumbnailAdapter.h(this.mList.get(this.mIndex))) < 0) {
            return;
        }
        int i = h + 1;
        if (i < this.mThumbnailAdapter.getItemCount()) {
            this.mThumbnailView.smoothScrollToPosition(i);
        } else {
            this.mThumbnailView.smoothScrollToPosition(h);
        }
        this.mThumbnailView.postDelayed(new d(this, h), 300L);
    }

    private void updateThumbnailView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            ArrayList<MediaModel> e2 = ao2.e();
            ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070682);
            if (e2 != null && e2.size() > 0) {
                this.mThumbnailView.setVisibility(0);
                this.mLineView.setVisibility(0);
                layoutParams.height = dimensionPixelSize;
                return;
            }
            this.mThumbnailView.setVisibility(8);
            this.mLineView.setVisibility(8);
            layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07066b)) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07068d);
        }
    }

    @Override // com.repackage.co2
    public void clickContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.mAnimation && this.mBarShowing) {
                hideBar();
            } else if (this.mAnimation) {
            } else {
                showBar();
            }
        }
    }

    @Override // com.repackage.co2
    public void hideBar() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mBarShowing) {
            this.mAnimation = true;
            float y = this.mPhotoHeader.getY();
            float y2 = this.mBottomView.getY();
            View view2 = this.mPhotoHeader;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "y", y, y - view2.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new e(this));
            ofFloat.start();
            View view3 = this.mBottomView;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "y", y2, y2 + view3.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ArrayList<MediaModel> arrayList;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 == this.mBackTv) {
                backDown();
                finish();
                return;
            }
            ArrayList<MediaModel> arrayList2 = this.mList;
            if (arrayList2 == null || this.mIndex >= arrayList2.size()) {
                return;
            }
            MediaModel mediaModel = this.mList.get(this.mIndex);
            if (view2 == this.mSelectView) {
                if (ao2.f(mediaModel)) {
                    this.mThumbnailAdapter.notifyItemRemoved(ao2.c(mediaModel));
                    ao2.h(mediaModel);
                    if (ao2.d() == 0) {
                        this.mThumbnailAdapter.i(null);
                    }
                    this.mSelectNumTv.setVisibility(8);
                    this.mSelectImg.setImageResource(R.drawable.obfuscated_res_0x7f081156);
                    if (ao2.d() > 0) {
                        string = getString(R.string.obfuscated_res_0x7f0f127c) + "(" + ao2.d() + SmallTailInfo.EMOTION_SUFFIX;
                    } else {
                        string = getString(R.string.obfuscated_res_0x7f0f127c);
                    }
                    this.mDoneTv.setText(string);
                    updateThumbnailView();
                    return;
                }
                int d2 = ao2.d();
                if (d2 == zn2.c) {
                    zn2.j(zn2.d);
                } else if (d2 > 0 && TextUtils.equals(zn2.d, "single") && !TextUtils.equals(ao2.b(), mediaModel.getType())) {
                    b03.f(this, R.string.obfuscated_res_0x7f0f126b).G();
                } else if (mediaModel.getSize() > 52428800 && TextUtils.equals(mediaModel.getType(), "image")) {
                    b03.f(this, R.string.obfuscated_res_0x7f0f126a).G();
                } else {
                    int d3 = ao2.d();
                    this.mThumbnailAdapter.notifyItemInserted(d3);
                    ao2.i(mediaModel);
                    if (this.mThumbnailAdapter.e() == null) {
                        this.mThumbnailAdapter.i(ao2.e());
                    }
                    this.mThumbnailView.smoothScrollToPosition(d3);
                    this.mSelectNumTv.setVisibility(0);
                    this.mSelectNumTv.setText(getSelectNum(mediaModel));
                    this.mSelectNumTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081155);
                    this.mDoneTv.setText(getString(R.string.obfuscated_res_0x7f0f127c) + "(" + ao2.d() + SmallTailInfo.EMOTION_SUFFIX);
                    this.mDoneTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a75));
                    updateThumbnailView();
                }
            } else if (view2 == this.mDoneTv) {
                if (ao2.d() == 0 && (arrayList = this.mList) != null && arrayList.size() > 0 && this.mIndex < this.mList.size()) {
                    ao2.i(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", zn2.e);
                bundle.putString("swanAppId", zn2.f);
                bundle.putParcelableArrayList("mediaModels", ao2.e());
                bundle.putString("swanTmpPath", zn2.j);
                zn2.g(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            finish();
            overridePendingTransition(R.anim.obfuscated_res_0x7f01012f, R.anim.obfuscated_res_0x7f01001c);
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClosing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            setOtherViewAlpha(i);
            setBackGroundAlpha(i);
            if (i != 0 && this.mDragActionOver) {
                setRootViewBackground(new ColorDrawable(Color.parseColor("#1a1a1a")));
                this.mDragView.setBackground(new ColorDrawable(0));
                SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.mAdapter;
                if (swanAppAlbumPreviewAdapter != null) {
                    swanAppAlbumPreviewAdapter.v(this.mIndex, 0);
                }
                this.mDragActionOver = false;
            }
            if (i == 0) {
                setRootViewBackground(new ColorDrawable(0));
                this.mDragView.setBackgroundColor(-16777216);
                SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter2 = this.mAdapter;
                if (swanAppAlbumPreviewAdapter2 != null) {
                    swanAppAlbumPreviewAdapter2.v(this.mIndex, -16777216);
                }
                this.mDragActionOver = true;
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.xd4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            int c0 = de3.c0(this);
            super.onCreate(bundle);
            de3.g(this, c0);
            setTranslucentStatus();
            uy2 uy2Var = new uy2(this);
            this.mTintManager = uy2Var;
            uy2Var.b(false);
            getWindow().setFlags(1024, 1024);
            if (!Fresco.hasBeenInitialized()) {
                Fresco.initialize(getApplicationContext());
            }
            setContentView(R.layout.obfuscated_res_0x7f0d07ce);
            if (getIntent() != null) {
                Bundle e2 = id3.e(getIntent(), "launchParams");
                this.mIndex = id3.f(e2, "previewPosition", 0);
                String g = id3.g(e2, "previewFrom");
                this.mFrom = g;
                if (TextUtils.equals(g, "bottomPreview")) {
                    ArrayList<MediaModel> arrayList = new ArrayList<>();
                    this.mList = arrayList;
                    arrayList.addAll(ao2.e());
                } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                    this.mList = e2 == null ? null : e2.getParcelableArrayList("mediaModels");
                } else {
                    this.mList = zn2.c();
                }
                if (this.mList == null) {
                    this.mList = new ArrayList<>();
                }
            }
            initView();
            setBottomSelectBtn();
            initBottomThumbnailView();
            adjustViewStatus();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.mAdapter;
            if (swanAppAlbumPreviewAdapter != null) {
                swanAppAlbumPreviewAdapter.k();
                this.mAdapter = null;
            }
            this.mThumbnailAdapter = null;
            this.mTintManager = null;
            if (this.mList != null) {
                this.mList = null;
            }
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onDragViewTouchEvent(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
            if (i == 4) {
                backDown();
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.ho2
    public void onMove(int i, int i2) {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) || (arrayList = this.mList) == null || this.mIndex >= arrayList.size()) {
            return;
        }
        this.mSelectNumTv.setText(getSelectNum(this.mList.get(this.mIndex)));
    }

    public void setRootViewBackground(Drawable drawable) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) || (view2 = this.mRootView) == null) {
            return;
        }
        view2.setBackground(drawable);
    }

    @Override // com.repackage.co2
    public void showBar() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.mBarShowing) {
            return;
        }
        this.mAnimation = true;
        float y = this.mPhotoHeader.getY();
        float y2 = this.mBottomView.getY();
        View view2 = this.mPhotoHeader;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "y", y, y + view2.getHeight());
        ofFloat.setDuration(this.mDuration);
        ofFloat.addListener(new f(this));
        ofFloat.start();
        View view3 = this.mBottomView;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "y", y2, y2 - view3.getHeight());
        ofFloat2.setDuration(this.mDuration);
        ofFloat2.start();
    }
}
