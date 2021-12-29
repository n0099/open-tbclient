package c.a.t0.o4.u;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import c.a.t0.o4.s;
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
/* loaded from: classes8.dex */
public class e implements c.a.s0.y0.b, View.OnClickListener {
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
    public int f21858e;

    /* renamed from: f  reason: collision with root package name */
    public int f21859f;

    /* renamed from: g  reason: collision with root package name */
    public int f21860g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21861h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21862i;

    /* renamed from: j  reason: collision with root package name */
    public BaseFragmentActivity f21863j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.t0.o4.u.c f21864k;
    public c.a.t0.o4.u.a l;
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

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

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
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f21863j == null) {
                return;
            }
            this.a.f21863j.finish();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

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
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f21863j == null) {
                return;
            }
            this.a.f21863j.closeLoadingDialog();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

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
            this.a = eVar;
        }

        @Override // c.a.t0.o4.u.f
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
                BdToast.i(this.a.f21863j, this.a.f21863j.getString(c.a.t0.o4.j.uploade_attation), c.a.t0.o4.f.icon_toast_game_error, false).q();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

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
            this.a = eVar;
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
                new c.a.s0.d0.f(null).o(this.a.f21864k.m(), true);
                return this.a.f21864k.m().toJsonString();
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
                this.a.f21863j.setResult(-1, intent);
                this.a.f21863j.finish();
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
        this.f21860g = 0;
        this.f21861h = false;
        this.f21862i = false;
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
        s(baseFragmentActivity, i2, i3);
        if (bundle == null) {
            t(this.f21863j.getIntent());
        } else {
            u(bundle);
        }
        P(0, this.f21858e);
        BaseFragmentActivity baseFragmentActivity2 = this.f21863j;
        if (baseFragmentActivity2 != null) {
            baseFragmentActivity2.registerListener(this.N);
            this.f21863j.registerListener(this.O);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21863j.closeLoadingDialog();
            int i2 = this.f21860g;
            if (i2 != 0) {
                if (i2 == 1) {
                    O(0);
                    return;
                }
                return;
            }
            c.a.t0.o4.u.c cVar = this.f21864k;
            if (cVar != null) {
                cVar.A(null);
            }
            m();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Q();
        }
    }

    public void C(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        c.a.t0.o4.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, strArr, iArr) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.p();
    }

    public void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.f21864k.m().toJsonString());
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

    public void E() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.n) == null) {
            return;
        }
        jVar.l();
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j jVar = this.n;
            if (jVar != null) {
                jVar.m();
            }
            if (this.f21862i) {
                this.f21863j.finish();
            }
        }
    }

    public final void G() {
        c.a.t0.o4.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.o();
    }

    public void H(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            this.I = intent;
            if (intent != null && this.f21864k != null) {
                String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                if (stringExtra != null) {
                    WriteImagesInfo m = this.f21864k.m();
                    m.parseJson(stringExtra);
                    m.updateQuality();
                    o(intent);
                    return;
                } else if (intent == null || StringUtils.isNull(intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH))) {
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH, intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH));
                    this.f21863j.setResult(-1, intent2);
                    this.f21863j.finish();
                    return;
                }
            }
            o(null);
        }
    }

    public final void I(ImageFileInfo imageFileInfo, boolean z) {
        c.a.t0.o4.u.a aVar;
        Fragment h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageFileInfo, z) == null) || (aVar = this.l) == null || (h2 = aVar.h(1)) == null || !(h2 instanceof AlbumImageBrowseFragment)) {
            return;
        }
        ((AlbumImageBrowseFragment) h2).refreshItem(imageFileInfo, z);
    }

    public void J(ImageFileInfo imageFileInfo, boolean z) {
        c.a.t0.o4.u.a aVar;
        Fragment h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, imageFileInfo, z) == null) || (aVar = this.l) == null || (h2 = aVar.h(0)) == null || !(h2 instanceof ImageListFragment)) {
            return;
        }
        ((ImageListFragment) h2).refreshItem(imageFileInfo, z);
    }

    public void K() {
        c.a.t0.o4.u.c cVar;
        c.a.t0.o4.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f21864k) == null || (aVar = this.l) == null) {
            return;
        }
        aVar.q(cVar.s());
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f21863j, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.f21863j, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.f21863j, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f21863j);
        }
        return invokeV.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f21863j, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.f21863j, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f21863j);
        }
        return invokeV.booleanValue;
    }

    public void N(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, navigationBar) == null) || navigationBar == null) {
            return;
        }
        this.l.r(navigationBar);
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 == 1) {
                P(i2, this.f21859f);
            } else {
                P(i2, this.f21858e);
            }
        }
    }

    public final void P(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || this.f21861h) {
            return;
        }
        FragmentTransaction beginTransaction = this.f21863j.getSupportFragmentManager().beginTransaction();
        Fragment findFragmentByTag = this.f21863j.getSupportFragmentManager().findFragmentByTag(this.l.i(this.f21860g));
        if (findFragmentByTag != null) {
            beginTransaction.hide(findFragmentByTag);
        }
        this.f21860g = i2;
        if (this.f21863j.getSupportFragmentManager().findFragmentByTag(this.l.i(i2)) != null) {
            beginTransaction.show(this.l.h(i2));
        } else {
            beginTransaction.add(i3, this.l.h(i2), this.l.i(i2));
        }
        beginTransaction.commitAllowingStateLoss();
        this.f21863j.getSupportFragmentManager().executePendingTransactions();
    }

    public final void Q() {
        c.a.t0.o4.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.t();
    }

    public final void R(int i2) {
        c.a.t0.o4.u.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || this.l == null || (cVar = this.f21864k) == null) {
            return;
        }
        cVar.B(!cVar.s());
        K();
        e(i2);
    }

    public void S(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbPageContext) == null) {
            if (this.v && this.w) {
                if (L()) {
                    return;
                }
                this.f21863j.showLoadingDialog(null);
                TbCaptureActivityConfig tbCaptureActivityConfig = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                tbCaptureActivityConfig.getIntent().putExtras(this.f21863j.getIntent());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig));
                this.f21862i = true;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
                if (c.a.s0.s.m.c.b()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 1).param("obj_source", c.a.s0.s.m.c.d() ? 2 : 1));
                }
            } else if (!s.d() || M()) {
            } else {
                ForumWriteData forumWriteData = new ForumWriteData(this.s, this.r, null, null);
                forumWriteData.statisticFrom = this.p;
                this.f21863j.showLoadingDialog(null);
                RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.F != 5 ? 2 : 3, forumWriteData, this.f21864k.m(), "", this.G);
                recordVideoActivityConfig.getIntent().putExtras(this.f21863j.getIntent());
                recordVideoActivityConfig.setShowType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
                this.f21862i = false;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
            }
        }
    }

    public boolean d(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            int l = this.f21864k.l();
            if (this.f21864k.D() < l) {
                f fVar = this.m;
                if (fVar == null || fVar.a(imageFileInfo)) {
                    ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                    imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                    imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                    imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                    imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                    imageFileInfo2.setIsGif(imageFileInfo.isGif());
                    imageFileInfo2.setIsLong(imageFileInfo.isLong());
                    this.f21864k.w(null);
                    this.f21864k.a(imageFileInfo2);
                    K();
                    return true;
                }
                return false;
            } else if (l()) {
                return d(imageFileInfo);
            } else {
                this.f21863j.showToast(String.format(this.f21863j.getString(c.a.t0.o4.j.max_choose_image_count), Integer.valueOf(l)));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void e(int i2) {
        c.a.t0.o4.u.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (cVar = this.f21864k) == null || !cVar.s() || StringUtils.isNull(this.q, true) || StringUtils.isNull(this.s, true)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c10349").param("fid", this.s).param("obj_type", this.q).param("obj_locate", i2));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.w : invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.t == 2) {
            this.m = new c(this);
        }
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.t0.o4.u.a aVar = this.l;
            if (aVar == null || aVar.j() == null || this.l.j().getGridView() == null) {
                return true;
            }
            return this.l.j().getGridView().getFirstVisiblePosition() == 0 && !this.l.j().getGridView().canScrollVertically(-1);
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.t == 3) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
            }
            if (this.t == 5) {
                this.f21863j.showLoadingDialog("正在上传");
                new d(this, null).execute(new String[0]);
            } else if (this.f21864k == null) {
            } else {
                j jVar = this.n;
                if (jVar == null || !jVar.i()) {
                    if (this.f21864k.p()) {
                        VideoFileInfo f2 = this.f21864k.f();
                        if (this.n == null) {
                            j jVar2 = new j(this.f21863j, this.r, this.s, "");
                            this.n = jVar2;
                            jVar2.p(this.E);
                            this.n.o(this.K, this.J, this.L, this.M);
                            c.a.t0.o4.u.a aVar = this.l;
                            if (aVar != null) {
                                aVar.s(this.n);
                            }
                        }
                        this.n.q(this.H);
                        this.n.r(this.p);
                        this.n.g(f2, this.o, this.q);
                    } else if (this.y && z()) {
                        y();
                    } else if (this.F == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f21863j);
                        newInstance.getIntent().setFlags(536870912);
                        newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                        newInstance.getIntent().putExtras(this.f21863j.getIntent());
                        newInstance.setType(9).setWriteImagesInfo(this.f21864k.m()).send();
                        this.f21863j.finish();
                    } else if (this.z) {
                        x();
                    } else {
                        o(null);
                    }
                }
            }
        }
    }

    public boolean k(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            this.f21864k.w(null);
            this.f21864k.c(imageFileInfo);
            K();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.f21863j.getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false) && this.f21864k.D() == (l = this.f21864k.l()) && l == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f21864k.g(), 0);
                    if (k(imageFileInfo)) {
                        J(imageFileInfo, false);
                        I(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Intent intent = new Intent();
            String k2 = this.f21864k.k();
            if (TextUtils.isEmpty(k2)) {
                k2 = "";
            }
            intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, k2);
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
            this.f21863j.setResult(0, intent);
            this.f21863j.finish();
        }
    }

    public void n(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, imageFileInfo) == null) || imageFileInfo == null) {
            return;
        }
        Intent intent = new Intent();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        linkedList.add(imageFileInfo);
        this.f21864k.m().setChosedFiles(linkedList);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.f21864k.m().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
        intent.putExtra("from_type", this.G);
        this.f21863j.setResult(-1, intent);
        this.f21863j.finish();
    }

    public final void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, intent) == null) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.f21864k.m().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
            intent2.putExtra("from_type", this.G);
            if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
                intent2.putExtra("file_name", intent.getStringExtra("file_name"));
            }
            this.f21863j.setResult(-1, intent2);
            this.f21863j.finish();
            if (AlbumActivityConfig.FROM_FLUTTER.equals(this.q)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921464, intent2));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view) == null) {
            if (view == this.l.f()) {
                j();
            } else if (view == this.l.e()) {
                j();
            } else if (view == this.l.d()) {
                c.a.t0.o4.u.c cVar = this.f21864k;
                if (cVar != null) {
                    cVar.A(null);
                }
                m();
            } else if (view == this.l.c()) {
                P(0, this.f21858e);
            } else if (view == this.l.l()) {
                R(2);
            } else if (view == this.l.k()) {
                R(1);
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f21861h = true;
            Q();
            this.f21863j.closeLoadingDialog();
            this.f21863j.dismissAllDialog();
            c.a.t0.o4.u.d.f().e();
            c.a.t0.o4.u.a aVar = this.l;
            if (aVar != null) {
                aVar.n();
            }
            j jVar = this.n;
            if (jVar != null) {
                jVar.j();
            }
            Intent intent = new Intent();
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.f21864k.m().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.t);
            intent.putExtra("from_type", this.G);
            Intent intent2 = this.I;
            if (intent2 != null && !StringUtils.isNull(intent2.getStringExtra("file_name"))) {
                intent.putExtra("file_name", this.I.getStringExtra("file_name"));
            }
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            G();
            j jVar = this.n;
            if (jVar != null) {
                jVar.k();
            }
            this.f21862i = false;
        }
    }

    @Override // c.a.s0.y0.b
    public void onViewChangeSkinType(int i2) {
        c.a.t0.o4.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048613, this, i2) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.onChangeSkinType(i2);
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            c.a.t0.o4.u.c cVar = this.f21864k;
            if (cVar != null && ListUtils.getCount(cVar.g()) != 0) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.f21864k.g()); i2++) {
                    ImageFileInfo imageFileInfo = this.f21864k.g().get(i2);
                    if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                        return i2;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.u : invokeV.intValue;
    }

    public c.a.t0.o4.u.c r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f21864k : (c.a.t0.o4.u.c) invokeV.objValue;
    }

    public final void s(BaseFragmentActivity baseFragmentActivity, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, baseFragmentActivity, i2, i3) == null) {
            this.f21863j = baseFragmentActivity;
            this.f21858e = i2;
            this.f21859f = i3;
            c.a.t0.o4.u.a aVar = new c.a.t0.o4.u.a(baseFragmentActivity.getPageContext(), this);
            this.l = aVar;
            aVar.m();
        }
    }

    public final void t(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            this.f21864k = new c.a.t0.o4.u.c(this.f21863j.getPageContext());
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
                this.f21864k.C(writeImagesInfo);
                this.f21864k.B(writeImagesInfo.isOriginalImg());
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
            i();
        }
    }

    public final void u(Bundle bundle) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            this.f21864k = new c.a.t0.o4.u.c(this.f21863j.getPageContext());
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
                this.f21864k.C(writeImagesInfo);
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
            i();
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public final void x() {
        c.a.t0.o4.u.c cVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (cVar = this.f21864k) == null || (m = cVar.m()) == null || m.getChosedFiles() == null || m.getChosedFiles().size() < 1) {
            return;
        }
        boolean booleanExtra = this.f21863j.getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
        VideoCoverSelectActivityConfig videoCoverSelectActivityConfig = new VideoCoverSelectActivityConfig(this.f21863j);
        videoCoverSelectActivityConfig.setImagePath(m.getChosedFiles().getFirst().getFilePath());
        videoCoverSelectActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
        videoCoverSelectActivityConfig.setVideoType(this.A);
        this.f21863j.sendMessage(new CustomMessage(2002001, videoCoverSelectActivityConfig));
    }

    public final void y() {
        c.a.t0.o4.u.c cVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (cVar = this.f21864k) == null || (m = cVar.m()) == null) {
            return;
        }
        this.f21863j.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f21863j, 12012, m, p())));
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            c.a.t0.o4.u.c cVar = this.f21864k;
            if (cVar == null || ListUtils.getCount(cVar.g()) == 0) {
                return false;
            }
            int i2 = 0;
            for (ImageFileInfo imageFileInfo : this.f21864k.g()) {
                if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i2 = i2 + 1) >= 2) {
                    return false;
                }
            }
            return i2 == 1;
        }
        return invokeV.booleanValue;
    }
}
