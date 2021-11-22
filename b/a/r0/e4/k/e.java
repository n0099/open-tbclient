package b.a.r0.e4.k;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbCaptureActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.protobuf.CodedInputStream;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class e implements b.a.q0.w0.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public FrsTabInfoData E;
    public int F;
    public int G;
    public int H;
    public Intent I;
    public PostPrefixData J;
    public AntiData K;
    public String L;
    public String M;
    public CustomMessageListener N;
    public CustomMessageListener O;

    /* renamed from: e  reason: collision with root package name */
    public int f17526e;

    /* renamed from: f  reason: collision with root package name */
    public int f17527f;

    /* renamed from: g  reason: collision with root package name */
    public int f17528g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17529h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17530i;
    public BaseFragmentActivity j;
    public b.a.r0.e4.k.c k;
    public b.a.r0.e4.k.a l;
    public f m;
    public j n;
    public String o;
    public int p;
    public String q;
    public String r;
    public String s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17531a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17531a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f17531a.j == null) {
                return;
            }
            this.f17531a.j.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17532a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17532a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f17532a.j == null) {
                return;
            }
            this.f17532a.j.closeLoadingDialog();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17533a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17533a = eVar;
        }

        @Override // b.a.r0.e4.k.f
        public boolean a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo != null) {
                    String filePath = imageFileInfo.getFilePath();
                    if (!StringUtils.isNULL(filePath)) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(filePath, options);
                        int i2 = options.outWidth;
                        if (options.outHeight >= 200 && i2 >= 200) {
                            return true;
                        }
                    }
                }
                BdToast.i(this.f17533a.j, this.f17533a.j.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).q();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17534a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17534a = eVar;
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this(eVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                new b.a.q0.d0.f(null).o(this.f17534a.k.m(), true);
                return this.f17534a.k.m().toJsonString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
                this.f17534a.j.setResult(-1, intent);
                this.f17534a.j.finish();
            }
        }
    }

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bundle, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17528g = 0;
        this.f17529h = false;
        this.f17530i = false;
        this.o = "";
        this.q = "";
        this.r = "";
        this.s = "0";
        this.t = 0;
        this.u = 0;
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = true;
        this.z = false;
        this.B = false;
        this.C = true;
        this.D = false;
        this.F = 5;
        this.G = 0;
        this.H = -1;
        this.J = null;
        this.K = null;
        this.L = "";
        this.M = "";
        this.N = new a(this, 2921583);
        this.O = new b(this, 2921614);
        r(baseFragmentActivity, i2, i3);
        if (bundle == null) {
            s(this.j.getIntent());
        } else {
            t(bundle);
        }
        X(0, this.f17526e);
        BaseFragmentActivity baseFragmentActivity2 = this.j;
        if (baseFragmentActivity2 != null) {
            baseFragmentActivity2.registerListener(this.N);
            this.j.registerListener(this.O);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17529h = true;
            Y();
            this.j.closeLoadingDialog();
            this.j.dismissAllDialog();
            b.a.r0.e4.k.d.f().e();
            b.a.r0.e4.k.a aVar = this.l;
            if (aVar != null) {
                aVar.n();
            }
            j jVar = this.n;
            if (jVar != null) {
                jVar.j();
            }
            Intent intent = new Intent();
            intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.k.m().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
            intent.putExtra("from_type", this.G);
            Intent intent2 = this.I;
            if (intent2 != null && !StringUtils.isNull(intent2.getStringExtra("file_name"))) {
                intent.putExtra("file_name", this.I.getStringExtra("file_name"));
            }
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Y();
        }
    }

    public void D(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        b.a.r0.e4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, strArr, iArr) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.p();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            O();
            j jVar = this.n;
            if (jVar != null) {
                jVar.k();
            }
            this.f17530i = false;
        }
    }

    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.k.m().toJsonString());
            bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.B);
            bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
            bundle.putString("forum_id", this.s);
            bundle.putString("forum_name", this.r);
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.u);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, this.C);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, this.D);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.v);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, this.w);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_GIF, this.x);
            bundle.putBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, this.z);
            bundle.putInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, this.A);
            bundle.putInt(IntentConfig.KEY_FROM_WRITE_TYPE, this.F);
            bundle.putSerializable("tab_list", this.E);
            bundle.putSerializable("anti_data", this.K);
            bundle.putSerializable("prefix_data", this.J);
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.L);
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.M);
        }
    }

    public void M() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jVar = this.n) == null) {
            return;
        }
        jVar.l();
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            j jVar = this.n;
            if (jVar != null) {
                jVar.m();
            }
            if (this.f17530i) {
                this.j.finish();
            }
        }
    }

    public final void O() {
        b.a.r0.e4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.o();
    }

    public void P(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            this.I = intent;
            if (intent != null && this.k != null) {
                String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                if (stringExtra != null) {
                    WriteImagesInfo m = this.k.m();
                    m.parseJson(stringExtra);
                    m.updateQuality();
                    n(intent);
                    return;
                } else if (intent == null || StringUtils.isNull(intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH))) {
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH, intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH));
                    this.j.setResult(-1, intent2);
                    this.j.finish();
                    return;
                }
            }
            n(null);
        }
    }

    public final void Q(ImageFileInfo imageFileInfo, boolean z) {
        b.a.r0.e4.k.a aVar;
        Fragment h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, imageFileInfo, z) == null) || (aVar = this.l) == null || (h2 = aVar.h(1)) == null || !(h2 instanceof AlbumImageBrowseFragment)) {
            return;
        }
        ((AlbumImageBrowseFragment) h2).refreshItem(imageFileInfo, z);
    }

    public void R(ImageFileInfo imageFileInfo, boolean z) {
        b.a.r0.e4.k.a aVar;
        Fragment h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, imageFileInfo, z) == null) || (aVar = this.l) == null || (h2 = aVar.h(0)) == null || !(h2 instanceof ImageListFragment)) {
            return;
        }
        ((ImageListFragment) h2).refreshItem(imageFileInfo, z);
    }

    public void S() {
        b.a.r0.e4.k.c cVar;
        b.a.r0.e4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (cVar = this.k) == null || (aVar = this.l) == null) {
            return;
        }
        aVar.q(cVar.s());
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.j, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.j, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.j, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.j);
        }
        return invokeV.booleanValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.j, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.j, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.j);
        }
        return invokeV.booleanValue;
    }

    public void V(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, navigationBar) == null) || navigationBar == null) {
            return;
        }
        this.l.r(navigationBar);
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 == 1) {
                X(i2, this.f17527f);
            } else {
                X(i2, this.f17526e);
            }
        }
    }

    public final void X(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || this.f17529h) {
            return;
        }
        FragmentTransaction beginTransaction = this.j.getSupportFragmentManager().beginTransaction();
        Fragment findFragmentByTag = this.j.getSupportFragmentManager().findFragmentByTag(this.l.i(this.f17528g));
        if (findFragmentByTag != null) {
            beginTransaction.hide(findFragmentByTag);
        }
        this.f17528g = i2;
        if (this.j.getSupportFragmentManager().findFragmentByTag(this.l.i(i2)) != null) {
            beginTransaction.show(this.l.h(i2));
        } else {
            beginTransaction.add(i3, this.l.h(i2), this.l.i(i2));
        }
        beginTransaction.commitAllowingStateLoss();
        this.j.getSupportFragmentManager().executePendingTransactions();
    }

    public final void Y() {
        b.a.r0.e4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.t();
    }

    public final void Z(int i2) {
        b.a.r0.e4.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || this.l == null || (cVar = this.k) == null) {
            return;
        }
        cVar.B(!cVar.s());
        S();
        d(i2);
    }

    public void a0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tbPageContext) == null) {
            if (this.v && this.w) {
                if (T()) {
                    return;
                }
                this.j.showLoadingDialog(null);
                TbCaptureActivityConfig tbCaptureActivityConfig = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                tbCaptureActivityConfig.getIntent().putExtras(this.j.getIntent());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig));
                this.f17530i = true;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
                if (b.a.q0.s.m.b.b()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 1).param("obj_source", b.a.q0.s.m.b.d() ? 2 : 1));
                }
            } else if (!b.a.r0.e4.i.e() || U()) {
            } else {
                ForumWriteData forumWriteData = new ForumWriteData(this.s, this.r, null, null);
                forumWriteData.statisticFrom = this.p;
                this.j.showLoadingDialog(null);
                RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.F != 5 ? 2 : 3, forumWriteData, this.k.m(), "", this.G);
                recordVideoActivityConfig.getIntent().putExtras(this.j.getIntent());
                recordVideoActivityConfig.setShowType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
                this.f17530i = false;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
            }
        }
    }

    public boolean c(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            int l = this.k.l();
            if (this.k.D() < l) {
                f fVar = this.m;
                if (fVar == null || fVar.a(imageFileInfo)) {
                    ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                    imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                    imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                    imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                    imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                    imageFileInfo2.setIsGif(imageFileInfo.isGif());
                    imageFileInfo2.setIsLong(imageFileInfo.isLong());
                    this.k.w(null);
                    this.k.a(imageFileInfo2);
                    S();
                    return true;
                }
                return false;
            } else if (k()) {
                return c(imageFileInfo);
            } else {
                this.j.showToast(String.format(this.j.getString(R.string.max_choose_image_count), Integer.valueOf(l)));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void d(int i2) {
        b.a.r0.e4.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (cVar = this.k) == null || !cVar.s() || StringUtils.isNull(this.q, true) || StringUtils.isNull(this.s, true)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c10349").param("fid", this.s).param("obj_type", this.q).param("obj_locate", i2));
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.v : invokeV.booleanValue;
    }

    @Override // b.a.q0.w0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.t == 2) {
            this.m = new c(this);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.t == 3) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
            }
            if (this.t == 5) {
                this.j.showLoadingDialog("正在上传");
                new d(this, null).execute(new String[0]);
            } else if (this.k == null) {
            } else {
                j jVar = this.n;
                if (jVar == null || !jVar.i()) {
                    if (this.k.p()) {
                        VideoFileInfo f2 = this.k.f();
                        if (this.n == null) {
                            j jVar2 = new j(this.j, this.r, this.s, "");
                            this.n = jVar2;
                            jVar2.p(this.E);
                            this.n.o(this.K, this.J, this.L, this.M);
                            b.a.r0.e4.k.a aVar = this.l;
                            if (aVar != null) {
                                aVar.s(this.n);
                            }
                        }
                        this.n.q(this.H);
                        this.n.r(this.p);
                        this.n.g(f2, this.o, this.q);
                    } else if (this.y && y()) {
                        x();
                    } else if (this.F == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.j);
                        newInstance.getIntent().setFlags(536870912);
                        newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                        newInstance.getIntent().putExtras(this.j.getIntent());
                        newInstance.setType(9).setWriteImagesInfo(this.k.m()).send();
                        this.j.finish();
                    } else if (this.z) {
                        w();
                    } else {
                        n(null);
                    }
                }
            }
        }
    }

    @Override // b.a.q0.w0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.q0.w0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            b.a.r0.e4.k.a aVar = this.l;
            if (aVar == null || aVar.j() == null || this.l.j().getGridView() == null) {
                return true;
            }
            return this.l.j().getGridView().getFirstVisiblePosition() == 0 && !this.l.j().getGridView().canScrollVertically(-1);
        }
        return invokeV.booleanValue;
    }

    public boolean j(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            this.k.w(null);
            this.k.c(imageFileInfo);
            S();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.j.getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false) && this.k.D() == (l = this.k.l()) && l == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.k.g(), 0);
                    if (j(imageFileInfo)) {
                        R(imageFileInfo, false);
                        Q(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Intent intent = new Intent();
            String k = this.k.k();
            if (TextUtils.isEmpty(k)) {
                k = "";
            }
            intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, k);
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
            this.j.setResult(0, intent);
            this.j.finish();
        }
    }

    public void m(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, imageFileInfo) == null) || imageFileInfo == null) {
            return;
        }
        Intent intent = new Intent();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        linkedList.add(imageFileInfo);
        this.k.m().setChosedFiles(linkedList);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.k.m().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
        intent.putExtra("from_type", this.G);
        this.j.setResult(-1, intent);
        this.j.finish();
    }

    public final void n(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, intent) == null) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.k.m().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
            intent2.putExtra("from_type", this.G);
            if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
                intent2.putExtra("file_name", intent.getStringExtra("file_name"));
            }
            this.j.setResult(-1, intent2);
            this.j.finish();
            if (AlbumActivityConfig.FROM_FLUTTER.equals(this.q)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921464, intent2));
            }
        }
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            b.a.r0.e4.k.c cVar = this.k;
            if (cVar != null && ListUtils.getCount(cVar.g()) != 0) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.k.g()); i2++) {
                    ImageFileInfo imageFileInfo = this.k.g().get(i2);
                    if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                        return i2;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
            if (view == this.l.f()) {
                i();
            } else if (view == this.l.e()) {
                i();
            } else if (view == this.l.d()) {
                b.a.r0.e4.k.c cVar = this.k;
                if (cVar != null) {
                    cVar.A(null);
                }
                l();
            } else if (view == this.l.c()) {
                X(0, this.f17526e);
            } else if (view == this.l.l()) {
                Z(2);
            } else if (view == this.l.k()) {
                Z(1);
            }
        }
    }

    @Override // b.a.q0.w0.a
    public void onViewChangeSkinType(int i2) {
        b.a.r0.e4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048613, this, i2) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.onChangeSkinType(i2);
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.u : invokeV.intValue;
    }

    public b.a.r0.e4.k.c q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.k : (b.a.r0.e4.k.c) invokeV.objValue;
    }

    public final void r(BaseFragmentActivity baseFragmentActivity, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, baseFragmentActivity, i2, i3) == null) {
            this.j = baseFragmentActivity;
            this.f17526e = i2;
            this.f17527f = i3;
            b.a.r0.e4.k.a aVar = new b.a.r0.e4.k.a(baseFragmentActivity.getPageContext(), this);
            this.l = aVar;
            aVar.m();
        }
    }

    public final void s(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, intent) == null) {
            this.k = new b.a.r0.e4.k.c(this.j.getPageContext());
            if (intent != null) {
                this.v = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
                this.w = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, false);
                this.x = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_GIF, true);
                if (this.v && this.w) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.k.C(writeImagesInfo);
                this.k.B(writeImagesInfo.isOriginalImg());
                this.B = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.t = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.q = intent.getStringExtra("from");
                this.s = intent.getStringExtra("forum_id");
                this.r = intent.getStringExtra("forum_name");
                this.u = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.C = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, true);
                this.D = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, false);
                this.y = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
                this.z = intent.getBooleanExtra(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.A = intent.getIntExtra(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                this.F = intent.getIntExtra(IntentConfig.KEY_FROM_WRITE_TYPE, 5);
                this.o = intent.getStringExtra("KEY_CALL_FROM");
                this.p = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
                this.G = intent.getIntExtra("from_type", 0);
                this.E = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
                this.H = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializableExtra = intent.getSerializableExtra("anti_data");
                if (serializableExtra instanceof AntiData) {
                    this.K = (AntiData) serializableExtra;
                }
                Serializable serializableExtra2 = intent.getSerializableExtra("prefix_data");
                if (serializableExtra2 instanceof PostPrefixData) {
                    this.J = (PostPrefixData) serializableExtra2;
                }
                this.L = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                this.M = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
            }
            h();
        }
    }

    public final void t(Bundle bundle) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            this.k = new b.a.r0.e4.k.c(this.j.getPageContext());
            if (bundle != null) {
                this.v = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
                this.w = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO);
                this.x = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_GIF);
                this.z = bundle.getBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.A = bundle.getInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                if (this.v && this.w) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.k.C(writeImagesInfo);
                this.B = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.t = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.s = bundle.getString("forum_id");
                this.r = bundle.getString("forum_name");
                this.u = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.F = bundle.getInt(IntentConfig.KEY_FROM_WRITE_TYPE);
                this.C = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE);
                this.D = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE);
                this.o = bundle.getString("KEY_CALL_FROM");
                this.p = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
                this.G = bundle.getInt("from_type");
                this.E = (FrsTabInfoData) bundle.getSerializable("tab_list");
                this.q = bundle.getString("from");
                this.H = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializable = bundle.getSerializable("anti_data");
                if (serializable instanceof AntiData) {
                    this.K = (AntiData) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("prefix_data");
                if (serializable2 instanceof PostPrefixData) {
                    this.J = (PostPrefixData) serializable2;
                }
                this.L = bundle.getString(IntentConfig.FORUM_FIRST_DIR, "");
                this.M = bundle.getString(IntentConfig.FORUM_SECOND_DIR, "");
            }
            h();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public final void w() {
        b.a.r0.e4.k.c cVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (cVar = this.k) == null || (m = cVar.m()) == null || m.getChosedFiles() == null || m.getChosedFiles().size() < 1) {
            return;
        }
        boolean booleanExtra = this.j.getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
        VideoCoverSelectActivityConfig videoCoverSelectActivityConfig = new VideoCoverSelectActivityConfig(this.j);
        videoCoverSelectActivityConfig.setImagePath(m.getChosedFiles().getFirst().getFilePath());
        videoCoverSelectActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
        videoCoverSelectActivityConfig.setVideoType(this.A);
        this.j.sendMessage(new CustomMessage(2002001, videoCoverSelectActivityConfig));
    }

    public final void x() {
        b.a.r0.e4.k.c cVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (cVar = this.k) == null || (m = cVar.m()) == null) {
            return;
        }
        this.j.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.j, 12012, m, o())));
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            b.a.r0.e4.k.c cVar = this.k;
            if (cVar == null || ListUtils.getCount(cVar.g()) == 0) {
                return false;
            }
            int i2 = 0;
            for (ImageFileInfo imageFileInfo : this.k.g()) {
                if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i2 = i2 + 1) >= 2) {
                    return false;
                }
            }
            return i2 == 1;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.j.closeLoadingDialog();
            int i2 = this.f17528g;
            if (i2 != 0) {
                if (i2 == 1) {
                    W(0);
                    return;
                }
                return;
            }
            b.a.r0.e4.k.c cVar = this.k;
            if (cVar != null) {
                cVar.A(null);
            }
            l();
        }
    }
}
