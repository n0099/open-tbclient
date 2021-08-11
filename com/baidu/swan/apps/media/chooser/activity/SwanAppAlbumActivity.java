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
import c.a.n0.a.g;
import c.a.n0.a.h;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q;
import c.a.n0.a.v2.q0;
import c.a.n0.a.v2.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_LOAD_FINISHED = 0;
    public static final int REQUEST_CODE_RESULT_DISPATCHER = 1;
    public static final String TAG = "SwanAppAlbumActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.i1.d.b.a mAdapter;
    public AdapterView.OnItemClickListener mAlbumNameClickListener;
    public View mAlbumNameListContainer;
    public View mAlbumNameListLayout;
    public HeightListView mAlbumNameListView;
    public TextView mAlbumNameTv;
    public RelativeLayout mBottomPreviewLayout;
    public TextView mBottomPreviewTv;
    public TextView mCancelTv;
    public LoadingLayout mEmptyView;
    public GridView mGridView;
    public ArrayList<c.a.n0.a.i1.d.f.a> mGroupImages;
    public Handler mHandler;
    public boolean mIsAnimationRunning;
    public boolean mIsOpenedList;
    public ActivityResultDispatcher mResultDispatcher;
    public TextView mSelectDoneTv;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumActivity f45825e;

        public a(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45825e = swanAppAlbumActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (!this.f45825e.mIsOpenedList || this.f45825e.mIsAnimationRunning) {
                    return true;
                }
                this.f45825e.startHideAnimation();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.n0.a.i1.d.d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumActivity f45826a;

        public b(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45826a = swanAppAlbumActivity;
        }

        @Override // c.a.n0.a.i1.d.d.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f45826a.changeNumberUi();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumActivity f45827a;

        public c(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45827a = swanAppAlbumActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f45827a.mIsOpenedList = false;
                this.f45827a.mIsAnimationRunning = false;
                this.f45827a.mAlbumNameListLayout.setVisibility(8);
                this.f45827a.mAlbumNameListContainer.setVisibility(8);
                Drawable drawable = this.f45827a.getResources().getDrawable(c.a.n0.a.e.swanapp_album_up_triangle);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f45827a.mAlbumNameTv.setCompoundDrawables(null, null, drawable, null);
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

    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumActivity f45828a;

        public d(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45828a = swanAppAlbumActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f45828a.mIsOpenedList = true;
                this.f45828a.mIsAnimationRunning = false;
                Drawable drawable = this.f45828a.getResources().getDrawable(c.a.n0.a.e.swanapp_album_down_triangle);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f45828a.mAlbumNameTv.setCompoundDrawables(null, null, drawable, null);
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

    /* loaded from: classes6.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumActivity f45829e;

        public e(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45829e = swanAppAlbumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f45829e.mIsOpenedList && !this.f45829e.mIsAnimationRunning) {
                    this.f45829e.startHideAnimation();
                }
                this.f45829e.mAlbumNameTv.setText(((c.a.n0.a.i1.d.f.a) this.f45829e.mGroupImages.get(i2)).c());
                ArrayList<MediaModel> arrayList = ((c.a.n0.a.i1.d.f.a) this.f45829e.mGroupImages.get(i2)).f6485h;
                this.f45829e.mAdapter.x(arrayList);
                if (arrayList.size() == 0) {
                    this.f45829e.mBottomPreviewLayout.setVisibility(8);
                } else {
                    this.f45829e.mBottomPreviewLayout.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SwanAppAlbumActivity> f45830a;

        public f(SwanAppAlbumActivity swanAppAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45830a = new WeakReference<>(swanAppAlbumActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                SwanAppAlbumActivity swanAppAlbumActivity = this.f45830a.get();
                if (swanAppAlbumActivity == null || swanAppAlbumActivity.isFinishing() || message.what != 0) {
                    return;
                }
                c.a.n0.a.e0.d.a(SwanAppAlbumActivity.TAG, "LoadAlbumTask finished");
                Object obj = message.obj;
                if (obj instanceof ArrayList) {
                    swanAppAlbumActivity.notifyUi(obj);
                }
            }
        }
    }

    public SwanAppAlbumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsOpenedList = false;
        this.mIsAnimationRunning = false;
        this.mGroupImages = new ArrayList<>();
        this.mAlbumNameClickListener = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNumberUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (c.a.n0.a.i1.d.c.e.d() > 0) {
                this.mSelectDoneTv.setTextColor(getResources().getColor(c.a.n0.a.c.swanapp_album_select_done_color));
                this.mBottomPreviewTv.setTextColor(getResources().getColor(c.a.n0.a.c.swanapp_album_bottom_preview_color));
                this.mSelectDoneTv.setText(getResources().getString(h.swanapp_album_selected_done_num, Integer.valueOf(c.a.n0.a.i1.d.c.e.d())));
                return;
            }
            this.mSelectDoneTv.setTextColor(getResources().getColor(c.a.n0.a.c.swanapp_album_select_done_unable_color));
            this.mBottomPreviewTv.setTextColor(getResources().getColor(c.a.n0.a.c.swanapp_album_bottom_preview_unable_color));
            this.mSelectDoneTv.setText(getString(h.swanapp_completion_text));
        }
    }

    private void getIntentData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || getIntent() == null) {
            return;
        }
        Bundle e2 = v.e(getIntent(), "launchParams");
        c.a.n0.a.i1.d.c.d.f6461b = v.g(e2, "launchType");
        c.a.n0.a.i1.d.c.d.f6467h = v.c(e2, "isShowCamera", true);
        c.a.n0.a.i1.d.c.d.f6468i = v.c(e2, "isFrontCamera", false);
        c.a.n0.a.i1.d.c.d.f6466g = v.f(e2, "maxDuration", 60);
        c.a.n0.a.i1.d.c.d.f6462c = v.f(e2, "count", 9);
        String g2 = v.g(e2, "mode");
        c.a.n0.a.i1.d.c.d.f6464e = v.c(e2, "compressed", true);
        c.a.n0.a.i1.d.c.d.f6465f = v.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g2)) {
            c.a.n0.a.i1.d.c.d.f6463d = g2;
        }
        c.a.n0.a.i1.d.c.d.f6469j = v.g(e2, "swanTmpPath");
        int i2 = c.a.n0.a.i1.d.c.d.f6462c;
        if (i2 < 1 || i2 > 9) {
            c.a.n0.a.i1.d.c.d.f6462c = 9;
        }
    }

    private void initAlbumNameAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mAlbumNameListView.setAdapter((ListAdapter) new c.a.n0.a.i1.d.b.b(this, c.a.n0.a.i1.d.c.d.f6461b, this.mGroupImages));
            this.mAlbumNameListView.setOnItemClickListener(this.mAlbumNameClickListener);
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mHandler = new f(this);
            this.mEmptyView.showLoading(true);
            q.i(new c.a.n0.a.i1.d.g.a(c.a.n0.a.i1.d.c.d.f6461b, this.mHandler), "loadAlbumTask");
        }
    }

    private void initImageAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            c.a.n0.a.i1.d.b.a aVar = new c.a.n0.a.i1.d.b.a(this);
            this.mAdapter = aVar;
            this.mGridView.setAdapter((ListAdapter) aVar);
            this.mAdapter.x(this.mGroupImages.get(0).f6485h);
            this.mAdapter.z(new b(this));
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mGridView = (GridView) findViewById(c.a.n0.a.f.album_gridview);
            this.mAlbumNameTv = (TextView) findViewById(c.a.n0.a.f.album_name);
            this.mSelectDoneTv = (TextView) findViewById(c.a.n0.a.f.album_select_done);
            this.mBottomPreviewTv = (TextView) findViewById(c.a.n0.a.f.album_bottom_preview_tv);
            this.mBottomPreviewLayout = (RelativeLayout) findViewById(c.a.n0.a.f.album_bottom_preview_container);
            this.mAlbumNameListLayout = findViewById(c.a.n0.a.f.album_name_list_layout);
            this.mAlbumNameListContainer = findViewById(c.a.n0.a.f.album_name_list_container);
            this.mAlbumNameListView = (HeightListView) findViewById(c.a.n0.a.f.album_name_list);
            this.mEmptyView = (LoadingLayout) findViewById(c.a.n0.a.f.album_content_loading);
            this.mCancelTv = (TextView) findViewById(c.a.n0.a.f.album_left_cancel);
            this.mAlbumNameListView.setListViewHeight(n0.f(this, 400.0f));
            this.mAlbumNameTv.setOnClickListener(this);
            this.mCancelTv.setOnClickListener(this);
            this.mSelectDoneTv.setOnClickListener(this);
            this.mBottomPreviewTv.setOnClickListener(this);
            this.mAlbumNameListLayout.setOnTouchListener(new a(this));
            this.mBottomPreviewLayout.setVisibility(0);
            this.mAlbumNameTv.setText(c.a.n0.a.i1.d.c.d.b(this, c.a.n0.a.i1.d.c.d.f6461b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, obj) == null) {
            this.mEmptyView.showLoading(false);
            ArrayList<c.a.n0.a.i1.d.f.a> arrayList = (ArrayList) obj;
            this.mGroupImages = arrayList;
            if (arrayList.size() > 0 && this.mGroupImages.get(0) != null) {
                if (this.mGroupImages.get(0).f() == null || this.mGroupImages.get(0).f().size() == 0) {
                    this.mBottomPreviewLayout.setVisibility(8);
                }
                Drawable drawable = getResources().getDrawable(c.a.n0.a.e.swanapp_album_up_triangle);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.mAlbumNameTv.setCompoundDrawables(null, null, drawable, null);
                this.mAlbumNameTv.setCompoundDrawablePadding(n0.f(this, 4.0f));
            } else {
                this.mBottomPreviewLayout.setVisibility(8);
            }
            this.mSelectDoneTv.setVisibility(0);
            changeNumberUi();
            initAlbumNameAdapter();
            initImageAdapter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHideAnimation() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.mIsOpenedList) {
            this.mIsAnimationRunning = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, c.a.n0.a.a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.mAlbumNameListContainer.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new c(this));
        }
    }

    private void startShowAnimation() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || this.mIsOpenedList) {
            return;
        }
        this.mAlbumNameListLayout.setVisibility(0);
        this.mAlbumNameListContainer.setVisibility(0);
        this.mIsAnimationRunning = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, c.a.n0.a.a.swanapp_album_floating_layer_in_animation);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.mAlbumNameListContainer.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d(this));
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            overridePendingTransition(0, c.a.n0.a.a.swanapp_album_slide_bottom_out);
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mResultDispatcher : (ActivityResultDispatcher) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) || getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i2 == 32770 && i3 == -1) {
            if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                c.a.n0.a.i1.d.b.a aVar = this.mAdapter;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                }
                changeNumberUi();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.mAlbumNameTv) {
                ArrayList<c.a.n0.a.i1.d.f.a> arrayList = this.mGroupImages;
                if (arrayList == null || arrayList.size() <= 1 || this.mIsAnimationRunning) {
                    return;
                }
                if (this.mIsOpenedList) {
                    startHideAnimation();
                } else {
                    startShowAnimation();
                }
            } else if (view == this.mSelectDoneTv) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.n0.a.i1.d.c.d.f6464e);
                bundle.putString("swanAppId", c.a.n0.a.i1.d.c.d.f6465f);
                bundle.putParcelableArrayList("mediaModels", c.a.n0.a.i1.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.n0.a.i1.d.c.d.f6469j);
                c.a.n0.a.i1.d.c.d.g(this, bundle);
            } else if (view == this.mCancelTv) {
                finish();
            } else if (view != this.mBottomPreviewTv || c.a.n0.a.i1.d.c.e.d() <= 0) {
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString("previewFrom", "bottomPreview");
                bundle2.putInt("previewPosition", 0);
                c.a.n0.a.i1.d.c.d.k(this, bundle2);
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, c.a.n0.o.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            int Z = q0.Z(this);
            super.onCreate(bundle);
            this.mResultDispatcher = new ActivityResultDispatcher(this, 1);
            q0.g(this, Z);
            setContentView(g.swanapp_album_layout);
            n0.a(this);
            getIntentData();
            initView();
            initData();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(0);
                this.mHandler = null;
            }
            c.a.n0.a.i1.d.c.e.a();
            c.a.n0.a.i1.d.c.d.a();
        }
    }
}
