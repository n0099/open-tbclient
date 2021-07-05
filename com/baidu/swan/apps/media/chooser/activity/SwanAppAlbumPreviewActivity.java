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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import d.a.q0.a.g;
import d.a.q0.a.h;
import d.a.q0.a.k;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.v;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, d.a.q0.a.i1.d.d.a, d.a.q0.a.i1.d.d.f {
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
    public d.a.q0.a.z1.a.c mTintManager;
    public ViewPager mViewPager;
    public ViewPager.OnPageChangeListener pageChangeListener;

    /* loaded from: classes4.dex */
    public class a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewActivity f11087a;

        /* renamed from: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0175a extends LinearSmoothScroller {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f11088a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0175a(a aVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11088a = aVar;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, displayMetrics)) == null) ? (this.f11088a.f11087a.getResources().getDisplayMetrics().density * 0.3f) / displayMetrics.density : invokeL.floatValue;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? super.computeScrollVectorForPosition(i2) : (PointF) invokeI.objValue;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11087a = swanAppAlbumPreviewActivity;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, recyclerView, state, i2) == null) {
                C0175a c0175a = new C0175a(this, recyclerView.getContext());
                c0175a.setTargetPosition(i2);
                startSmoothScroll(c0175a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends SwanAppThumbnailClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.c.a f11089c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f11090d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewActivity f11091e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity, RecyclerView recyclerView, d.a.q0.a.i1.d.c.a aVar, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity, recyclerView, aVar, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((RecyclerView) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11091e = swanAppAlbumPreviewActivity;
            this.f11089c = aVar;
            this.f11090d = itemTouchHelper;
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void b(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || this.f11091e.mList == null) {
                return;
            }
            MediaModel g2 = this.f11091e.mThumbnailAdapter.g(viewHolder.getAdapterPosition());
            int size = this.f11091e.mList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f11091e.mList.get(i2) != null && ((MediaModel) this.f11091e.mList.get(i2)).equals(g2)) {
                    this.f11089c.a(true);
                    this.f11091e.mViewPager.setCurrentItem(i2);
                    this.f11089c.a(false);
                    return;
                }
            }
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void c(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                ArrayList<MediaModel> m = this.f11091e.mThumbnailAdapter.m();
                if (viewHolder.getLayoutPosition() < 0 || m == null || viewHolder.getLayoutPosition() == m.size()) {
                    return;
                }
                this.f11090d.startDrag(viewHolder);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewActivity f11092e;

        public c(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11092e = swanAppAlbumPreviewActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f11092e.mAdapter.q();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f11092e.mIndex = i2;
                this.f11092e.smoothScrollToPosition();
                this.f11092e.setBottomSelectBtn();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f11093e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewActivity f11094f;

        public d(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11094f = swanAppAlbumPreviewActivity;
            this.f11093e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11093e > 0) {
                    this.f11094f.mThumbnailView.smoothScrollToPosition(this.f11093e - 1);
                } else {
                    this.f11094f.mThumbnailView.smoothScrollToPosition(this.f11093e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewActivity f11095e;

        public e(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11095e = swanAppAlbumPreviewActivity;
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
                this.f11095e.mAnimation = false;
                SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = this.f11095e;
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

    /* loaded from: classes4.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewActivity f11096e;

        public f(SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11096e = swanAppAlbumPreviewActivity;
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
                this.f11096e.mAnimation = false;
                SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = this.f11096e;
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
        DEBUG = k.f49133a;
    }

    public SwanAppAlbumPreviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private d.a.q0.a.i1.d.c.a getNoDurationScroller(ViewPager viewPager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, viewPager)) == null) {
            d.a.q0.a.i1.d.c.a aVar = new d.a.q0.a.i1.d.c.a(viewPager.getContext());
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, aVar);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            return aVar;
        }
        return (d.a.q0.a.i1.d.c.a) invokeL.objValue;
    }

    private String getSelectNum(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, mediaModel)) == null) ? String.valueOf(d.a.q0.a.i1.d.c.e.c(mediaModel) + 1) : (String) invokeL.objValue;
    }

    private void initBottomThumbnailView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mThumbnailView = (RecyclerView) findViewById(d.a.q0.a.f.thumbnail_drag_view);
            this.mLineView = findViewById(d.a.q0.a.f.album_preview_line);
            a aVar = new a(this, this);
            aVar.setOrientation(0);
            this.mThumbnailView.setLayoutManager(aVar);
            SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
            this.mThumbnailAdapter = swanAppThumbnailAdapter;
            this.mThumbnailView.setAdapter(swanAppThumbnailAdapter);
            this.mThumbnailAdapter.q(d.a.q0.a.i1.d.c.e.e() == null ? null : d.a.q0.a.i1.d.c.e.e());
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.mThumbnailAdapter));
            itemTouchHelper.attachToRecyclerView(this.mThumbnailView);
            d.a.q0.a.i1.d.c.a noDurationScroller = getNoDurationScroller(this.mViewPager);
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
            this.mRootView = findViewById(d.a.q0.a.f.album_preview_content);
            DragView dragView = (DragView) findViewById(d.a.q0.a.f.drag_view);
            this.mDragView = dragView;
            dragView.setOnCloseListener(this);
            this.mDragView.setBackgroundColor(-16777216);
            this.mViewPager = (ViewPager) findViewById(d.a.q0.a.f.album_preview_viewpager);
            this.mSelectImg = (ImageView) findViewById(d.a.q0.a.f.album_preview_select_checkbox);
            this.mBackTv = findViewById(d.a.q0.a.f.album_preview_back_layout);
            this.mSelectView = findViewById(d.a.q0.a.f.album_preview_select_view);
            this.mDoneTv = (TextView) findViewById(d.a.q0.a.f.album_preview_done);
            this.mSelectNumTv = (TextView) findViewById(d.a.q0.a.f.album_preview_select);
            this.mBottomView = findViewById(d.a.q0.a.f.album_preview_bottom);
            this.mPhotoHeader = findViewById(d.a.q0.a.f.album_preview_header);
            this.mBackTv.setOnClickListener(this);
            this.mDoneTv.setOnClickListener(this);
            this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.mList);
            this.mAdapter = swanAppAlbumPreviewAdapter;
            this.mViewPager.setAdapter(swanAppAlbumPreviewAdapter);
            this.mAdapter.v(this);
            this.mViewPager.setCurrentItem(this.mIndex);
            this.mSelectView.setOnClickListener(this);
            this.mDoneTv.setBackgroundResource(d.a.q0.a.e.swanapp_album_preview_done_bg);
            this.mDoneTv.setTextColor(getResources().getColor(d.a.q0.a.c.swanapp_album_preview_select_done_color));
            if (d.a.q0.a.i1.d.c.e.d() != 0) {
                string = getString(h.swanapp_completion_text) + "(" + d.a.q0.a.i1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                string = getString(h.swanapp_completion_text);
            }
            this.mDoneTv.setText(string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBackGroundAlpha(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i2) == null) {
            int abs = Math.abs(i2);
            if (abs >= 0) {
                float f2 = abs;
                if (f2 < 300.0f) {
                    i3 = (int) (255.0f - ((f2 / 300.0f) * 20.0f));
                    this.mRootView.getBackground().mutate().setAlpha(i3 >= 0 ? i3 : 0);
                }
            }
            float f3 = abs;
            if (f3 >= 300.0f) {
                float f4 = 235;
                i3 = (int) (f4 - (((f3 - 300.0f) / 900.0f) * f4));
            } else {
                i3 = 0;
            }
            this.mRootView.getBackground().mutate().setAlpha(i3 >= 0 ? i3 : 0);
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
        if (d.a.q0.a.i1.d.c.e.g(mediaModel)) {
            this.mSelectNumTv.setVisibility(0);
            this.mSelectNumTv.setText(getSelectNum(this.mList.get(this.mIndex)));
            this.mSelectNumTv.setBackgroundResource(d.a.q0.a.e.swanapp_album_preview_select_bg);
            return;
        }
        this.mSelectNumTv.setVisibility(8);
        if (d.a.q0.a.i1.d.c.d.f(d.a.q0.a.i1.d.c.d.f48804d, mediaModel)) {
            this.mSelectImg.setImageResource(d.a.q0.a.e.swanapp_album_preview_unselect_unable);
        } else {
            this.mSelectImg.setImageResource(d.a.q0.a.e.swanapp_album_preview_unselect);
        }
    }

    private void setOtherViewAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i2) == null) {
            float f2 = i2 == 0 ? 0.0f : 1.0f;
            View view = this.mBottomView;
            if (view != null) {
                view.setAlpha(1.0f - f2);
            }
            View view2 = this.mPhotoHeader;
            if (view2 != null) {
                view2.setAlpha(1.0f - f2);
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
        int p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || this.mThumbnailAdapter == null || this.mIndex >= this.mList.size() || (p = this.mThumbnailAdapter.p(this.mList.get(this.mIndex))) < 0) {
            return;
        }
        int i2 = p + 1;
        if (i2 < this.mThumbnailAdapter.getItemCount()) {
            this.mThumbnailView.smoothScrollToPosition(i2);
        } else {
            this.mThumbnailView.smoothScrollToPosition(p);
        }
        this.mThumbnailView.postDelayed(new d(this, p), 300L);
    }

    private void updateThumbnailView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            ArrayList<MediaModel> e2 = d.a.q0.a.i1.d.c.e.e();
            ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.a.q0.a.d.swanapp_preview_bottom_height);
            if (e2 != null && e2.size() > 0) {
                this.mThumbnailView.setVisibility(0);
                this.mLineView.setVisibility(0);
                layoutParams.height = dimensionPixelSize;
                return;
            }
            this.mThumbnailView.setVisibility(8);
            this.mLineView.setVisibility(8);
            layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(d.a.q0.a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(d.a.q0.a.d.swanapp_preview_drag_view_height);
        }
    }

    @Override // d.a.q0.a.i1.d.d.a
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

    @Override // d.a.q0.a.i1.d.d.a
    public void hideBar() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mBarShowing) {
            this.mAnimation = true;
            float y = this.mPhotoHeader.getY();
            float y2 = this.mBottomView.getY();
            View view = this.mPhotoHeader;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "y", y, y - view.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new e(this));
            ofFloat.start();
            View view2 = this.mBottomView;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "y", y2, y2 + view2.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList<MediaModel> arrayList;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view == this.mBackTv) {
                backDown();
                finish();
                return;
            }
            ArrayList<MediaModel> arrayList2 = this.mList;
            if (arrayList2 == null || this.mIndex >= arrayList2.size()) {
                return;
            }
            MediaModel mediaModel = this.mList.get(this.mIndex);
            if (view == this.mSelectView) {
                if (d.a.q0.a.i1.d.c.e.f(mediaModel)) {
                    this.mThumbnailAdapter.notifyItemRemoved(d.a.q0.a.i1.d.c.e.c(mediaModel));
                    d.a.q0.a.i1.d.c.e.h(mediaModel);
                    if (d.a.q0.a.i1.d.c.e.d() == 0) {
                        this.mThumbnailAdapter.q(null);
                    }
                    this.mSelectNumTv.setVisibility(8);
                    this.mSelectImg.setImageResource(d.a.q0.a.e.swanapp_album_preview_unselect);
                    if (d.a.q0.a.i1.d.c.e.d() > 0) {
                        string = getString(h.swanapp_completion_text) + "(" + d.a.q0.a.i1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX;
                    } else {
                        string = getString(h.swanapp_completion_text);
                    }
                    this.mDoneTv.setText(string);
                    updateThumbnailView();
                    return;
                }
                int d2 = d.a.q0.a.i1.d.c.e.d();
                if (d2 == d.a.q0.a.i1.d.c.d.f48803c) {
                    d.a.q0.a.i1.d.c.d.j(d.a.q0.a.i1.d.c.d.f48804d);
                } else if (d2 > 0 && TextUtils.equals(d.a.q0.a.i1.d.c.d.f48804d, "single") && !TextUtils.equals(d.a.q0.a.i1.d.c.e.b(), mediaModel.getType())) {
                    d.a.q0.a.z1.b.f.e.f(this, h.swanapp_album_select_single).F();
                } else if (mediaModel.getSize() > 52428800 && TextUtils.equals(mediaModel.getType(), "image")) {
                    d.a.q0.a.z1.b.f.e.f(this, h.swanapp_album_photo_too_big).F();
                } else {
                    int d3 = d.a.q0.a.i1.d.c.e.d();
                    this.mThumbnailAdapter.notifyItemInserted(d3);
                    d.a.q0.a.i1.d.c.e.i(mediaModel);
                    if (this.mThumbnailAdapter.m() == null) {
                        this.mThumbnailAdapter.q(d.a.q0.a.i1.d.c.e.e());
                    }
                    this.mThumbnailView.smoothScrollToPosition(d3);
                    this.mSelectNumTv.setVisibility(0);
                    this.mSelectNumTv.setText(getSelectNum(mediaModel));
                    this.mSelectNumTv.setBackgroundResource(d.a.q0.a.e.swanapp_album_preview_select_bg);
                    this.mDoneTv.setText(getString(h.swanapp_completion_text) + "(" + d.a.q0.a.i1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX);
                    this.mDoneTv.setTextColor(getResources().getColor(d.a.q0.a.c.swanapp_album_preview_select_done_color));
                    updateThumbnailView();
                }
            } else if (view == this.mDoneTv) {
                if (d.a.q0.a.i1.d.c.e.d() == 0 && (arrayList = this.mList) != null && arrayList.size() > 0 && this.mIndex < this.mList.size()) {
                    d.a.q0.a.i1.d.c.e.i(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.a.q0.a.i1.d.c.d.f48805e);
                bundle.putString("swanAppId", d.a.q0.a.i1.d.c.d.f48806f);
                bundle.putParcelableArrayList("mediaModels", d.a.q0.a.i1.d.c.e.e());
                bundle.putString("swanTmpPath", d.a.q0.a.i1.d.c.d.j);
                d.a.q0.a.i1.d.c.d.g(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            finish();
            overridePendingTransition(d.a.q0.a.a.swanapp_album_preview_enter, d.a.q0.a.a.aiapps_hold);
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClosing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            setOtherViewAlpha(i2);
            setBackGroundAlpha(i2);
            if (i2 != 0 && this.mDragActionOver) {
                setRootViewBackground(new ColorDrawable(Color.parseColor("#1a1a1a")));
                this.mDragView.setBackground(new ColorDrawable(0));
                SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.mAdapter;
                if (swanAppAlbumPreviewAdapter != null) {
                    swanAppAlbumPreviewAdapter.u(this.mIndex, 0);
                }
                this.mDragActionOver = false;
            }
            if (i2 == 0) {
                setRootViewBackground(new ColorDrawable(0));
                this.mDragView.setBackgroundColor(-16777216);
                SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter2 = this.mAdapter;
                if (swanAppAlbumPreviewAdapter2 != null) {
                    swanAppAlbumPreviewAdapter2.u(this.mIndex, -16777216);
                }
                this.mDragActionOver = true;
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.q0.o.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            int Z = q0.Z(this);
            super.onCreate(bundle);
            q0.g(this, Z);
            setTranslucentStatus();
            d.a.q0.a.z1.a.c cVar = new d.a.q0.a.z1.a.c(this);
            this.mTintManager = cVar;
            cVar.b(false);
            getWindow().setFlags(1024, 1024);
            setContentView(g.swanapp_album_preview_layout);
            if (getIntent() != null) {
                Bundle e2 = v.e(getIntent(), "launchParams");
                this.mIndex = v.f(e2, "previewPosition", 0);
                String g2 = v.g(e2, "previewFrom");
                this.mFrom = g2;
                if (TextUtils.equals(g2, "bottomPreview")) {
                    ArrayList<MediaModel> arrayList = new ArrayList<>();
                    this.mList = arrayList;
                    arrayList.addAll(d.a.q0.a.i1.d.c.e.e());
                } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                    this.mList = e2 == null ? null : e2.getParcelableArrayList("mediaModels");
                } else {
                    this.mList = d.a.q0.a.i1.d.c.d.c();
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                backDown();
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // d.a.q0.a.i1.d.d.f
    public void onMove(int i2, int i3) {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) || (arrayList = this.mList) == null || this.mIndex >= arrayList.size()) {
            return;
        }
        this.mSelectNumTv.setText(getSelectNum(this.mList.get(this.mIndex)));
    }

    public void setRootViewBackground(Drawable drawable) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) || (view = this.mRootView) == null) {
            return;
        }
        view.setBackground(drawable);
    }

    @Override // d.a.q0.a.i1.d.d.a
    public void showBar() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.mBarShowing) {
            return;
        }
        this.mAnimation = true;
        float y = this.mPhotoHeader.getY();
        float y2 = this.mBottomView.getY();
        View view = this.mPhotoHeader;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "y", y, y + view.getHeight());
        ofFloat.setDuration(this.mDuration);
        ofFloat.addListener(new f(this));
        ofFloat.start();
        View view2 = this.mBottomView;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "y", y2, y2 - view2.getHeight());
        ofFloat2.setDuration(this.mDuration);
        ofFloat2.start();
    }
}
