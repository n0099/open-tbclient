package c.a.p0.s4.k;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.atomData.WorkPublishManager;
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
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class e implements c.a.o0.x0.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int M = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTabInfoData A;
    public int B;
    public int C;
    public int D;
    public Intent E;
    public boolean F;
    public PostPrefixData G;
    public AntiData H;
    public String I;
    public String J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f18353b;

    /* renamed from: c  reason: collision with root package name */
    public int f18354c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18355d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18356e;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragmentActivity f18357f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s4.k.c f18358g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.s4.k.a f18359h;
    public f i;
    public j j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f18357f == null) {
                return;
            }
            this.a.f18357f.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f18357f == null) {
                return;
            }
            this.a.f18357f.closeLoadingDialog();
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.p0.s4.k.f
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
                        int i = options.outWidth;
                        if (options.outHeight >= 200 && i >= 200) {
                            return true;
                        }
                    }
                }
                BdToast.i(this.a.f18357f, this.a.f18357f.getString(R.string.obfuscated_res_0x7f0f1495), R.drawable.obfuscated_res_0x7f080a66, false).q();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                new c.a.o0.c0.f(null).o(this.a.f18358g.m(), true);
                return this.a.f18358g.m().toJsonString();
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
                this.a.f18357f.setResult(-1, intent);
                this.a.f18357f.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-293533089, "Lc/a/p0/s4/k/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-293533089, "Lc/a/p0/s4/k/e;");
        }
    }

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bundle, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18354c = 0;
        this.f18355d = false;
        this.f18356e = false;
        this.k = "";
        this.m = "";
        this.n = "";
        this.o = "0";
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = false;
        this.x = false;
        this.y = true;
        this.z = false;
        this.B = 5;
        this.C = 0;
        this.D = -1;
        this.G = null;
        this.H = null;
        this.I = "";
        this.J = "";
        this.K = new a(this, 2921583);
        this.L = new b(this, 2921614);
        r(baseFragmentActivity, i, i2);
        if (bundle == null) {
            s(this.f18357f.getIntent());
        } else {
            t(bundle);
        }
        P(0, this.a);
        BaseFragmentActivity baseFragmentActivity2 = this.f18357f;
        if (baseFragmentActivity2 != null) {
            baseFragmentActivity2.registerListener(this.K);
            this.f18357f.registerListener(this.L);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18357f.closeLoadingDialog();
            int i = this.f18354c;
            if (i != 0) {
                if (i == 1) {
                    O(0);
                    return;
                }
                return;
            }
            c.a.p0.s4.k.c cVar = this.f18358g;
            if (cVar != null) {
                cVar.A(null);
            }
            l();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Q();
        }
    }

    public void C(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        c.a.p0.s4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) || (aVar = this.f18359h) == null) {
            return;
        }
        aVar.r();
    }

    public void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.f18358g.m().toJsonString());
            bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.x);
            bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            bundle.putString("forum_id", this.o);
            bundle.putString("forum_name", this.n);
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.q);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, this.y);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, this.z);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.r);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, this.s);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_GIF, this.t);
            bundle.putBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, this.v);
            bundle.putInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, this.w);
            bundle.putInt(IntentConfig.KEY_FROM_WRITE_TYPE, this.B);
            bundle.putSerializable("tab_list", this.A);
            bundle.putSerializable("anti_data", this.H);
            bundle.putSerializable("prefix_data", this.G);
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.I);
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.J);
        }
    }

    public void E() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.j) == null) {
            return;
        }
        jVar.l();
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j jVar = this.j;
            if (jVar != null) {
                jVar.m();
            }
            if (this.f18356e) {
                this.f18357f.finish();
            }
        }
    }

    public final void G() {
        c.a.p0.s4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f18359h) == null) {
            return;
        }
        aVar.q();
    }

    public void H(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            this.E = intent;
            if (intent != null && this.f18358g != null) {
                String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                if (stringExtra != null) {
                    WriteImagesInfo m = this.f18358g.m();
                    m.parseJson(stringExtra);
                    m.updateQuality();
                    n(intent);
                    return;
                } else if (intent == null || StringUtils.isNull(intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH))) {
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH, intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH));
                    this.f18357f.setResult(-1, intent2);
                    this.f18357f.finish();
                    return;
                }
            }
            n(null);
        }
    }

    public final void I(ImageFileInfo imageFileInfo, boolean z) {
        c.a.p0.s4.k.a aVar;
        Fragment j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageFileInfo, z) == null) || (aVar = this.f18359h) == null || (j = aVar.j(1)) == null || !(j instanceof AlbumImageBrowseFragment)) {
            return;
        }
        ((AlbumImageBrowseFragment) j).T0(imageFileInfo, z);
    }

    public void J(ImageFileInfo imageFileInfo, boolean z) {
        c.a.p0.s4.k.a aVar;
        Fragment j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, imageFileInfo, z) == null) || (aVar = this.f18359h) == null || (j = aVar.j(0)) == null || !(j instanceof ImageListFragment)) {
            return;
        }
        ((ImageListFragment) j).d1(imageFileInfo, z);
    }

    public void K() {
        c.a.p0.s4.k.c cVar;
        c.a.p0.s4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f18358g) == null || (aVar = this.f18359h) == null) {
            return;
        }
        aVar.s(cVar.s());
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f18357f, "android.permission.CAMERA");
            permissionJudgePolicy.appendRequestPermission(this.f18357f, "android.permission.RECORD_AUDIO");
            permissionJudgePolicy.appendRequestPermission(this.f18357f, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f18357f);
        }
        return invokeV.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f18357f, "android.permission.CAMERA");
            permissionJudgePolicy.appendRequestPermission(this.f18357f, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f18357f);
        }
        return invokeV.booleanValue;
    }

    public void N(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, navigationBar) == null) || navigationBar == null) {
            return;
        }
        this.f18359h.t(navigationBar);
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (i == 1) {
                P(i, this.f18353b);
            } else {
                P(i, this.a);
            }
        }
    }

    public final void P(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) || this.f18355d) {
            return;
        }
        FragmentTransaction beginTransaction = this.f18357f.getSupportFragmentManager().beginTransaction();
        Fragment findFragmentByTag = this.f18357f.getSupportFragmentManager().findFragmentByTag(this.f18359h.k(this.f18354c));
        if (findFragmentByTag != null) {
            beginTransaction.hide(findFragmentByTag);
        }
        this.f18354c = i;
        if (this.f18357f.getSupportFragmentManager().findFragmentByTag(this.f18359h.k(i)) != null) {
            beginTransaction.show(this.f18359h.j(i));
        } else {
            beginTransaction.add(i2, this.f18359h.j(i), this.f18359h.k(i));
        }
        beginTransaction.commitAllowingStateLoss();
        this.f18357f.getSupportFragmentManager().executePendingTransactions();
    }

    public final void Q() {
        c.a.p0.s4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (aVar = this.f18359h) == null) {
            return;
        }
        aVar.v();
    }

    public final void R(int i) {
        c.a.p0.s4.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || this.f18359h == null || (cVar = this.f18358g) == null) {
            return;
        }
        cVar.B(!cVar.s());
        K();
        d(i);
    }

    public void S(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbPageContext) == null) {
            if (this.r && this.s) {
                if (L()) {
                    return;
                }
                this.f18357f.showLoadingDialog(null);
                TbCaptureActivityConfig tbCaptureActivityConfig = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                tbCaptureActivityConfig.getIntent().putExtras(this.f18357f.getIntent());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig));
                this.f18356e = true;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
                if (WorkPublishManager.isWorkPublishLocate()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 1).param("obj_source", WorkPublishManager.isWorkPublishLocateVideoCenter() ? 2 : 1));
                }
            } else if (!c.a.p0.s4.i.d() || M()) {
            } else {
                ForumWriteData forumWriteData = new ForumWriteData(this.o, this.n, null, null);
                forumWriteData.statisticFrom = this.l;
                this.f18357f.showLoadingDialog(null);
                RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.B != 5 ? 2 : 3, forumWriteData, this.f18358g.m(), "", this.C);
                recordVideoActivityConfig.getIntent().putExtras(this.f18357f.getIntent());
                recordVideoActivityConfig.setShowType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
                this.f18356e = false;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
            }
        }
    }

    public boolean c(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            int l = this.f18358g.l();
            if (this.f18358g.D() < l) {
                f fVar = this.i;
                if (fVar == null || fVar.a(imageFileInfo)) {
                    ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                    imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                    imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                    imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                    imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                    imageFileInfo2.setIsGif(imageFileInfo.isGif());
                    imageFileInfo2.setIsLong(imageFileInfo.isLong());
                    this.f18358g.w(null);
                    this.f18358g.a(imageFileInfo2);
                    K();
                    return true;
                }
                return false;
            } else if (k()) {
                return c(imageFileInfo);
            } else {
                String format = String.format(this.f18357f.getString(R.string.obfuscated_res_0x7f0f0a92), Integer.valueOf(l));
                if (l == M) {
                    BdTopToast bdTopToast = new BdTopToast(this.f18357f);
                    bdTopToast.i(false);
                    bdTopToast.h(format);
                    bdTopToast.j((ViewGroup) this.f18357f.findViewById(R.id.obfuscated_res_0x7f091de5));
                } else {
                    this.f18357f.showToast(format);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void d(int i) {
        c.a.p0.s4.k.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || (cVar = this.f18358g) == null || !cVar.s() || StringUtils.isNull(this.m, true) || StringUtils.isNull(this.o, true)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c10349").param("fid", this.o).param("obj_type", this.m).param("obj_locate", i));
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // c.a.o0.x0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.p == 2) {
            this.i = new c(this);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.p == 3) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
            }
            int i = this.p;
            if (i != 5 && i != 6) {
                if (this.f18358g == null) {
                    return;
                }
                j jVar = this.j;
                if (jVar == null || !jVar.i()) {
                    if (this.f18358g.p()) {
                        VideoFileInfo f2 = this.f18358g.f();
                        if (this.j == null) {
                            j jVar2 = new j(this.f18357f, this.n, this.o, "");
                            this.j = jVar2;
                            jVar2.p(this.A);
                            this.j.o(this.H, this.G, this.I, this.J);
                            c.a.p0.s4.k.a aVar = this.f18359h;
                            if (aVar != null) {
                                aVar.u(this.j);
                            }
                        }
                        this.j.q(this.D);
                        this.j.r(this.l);
                        this.j.g(f2, this.k, this.m);
                        return;
                    } else if (this.u && z()) {
                        y();
                        return;
                    } else if (this.B == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f18357f);
                        newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                        newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                        newInstance.getIntent().putExtras(this.f18357f.getIntent());
                        newInstance.setType(9).setForumId(TextUtils.isEmpty(this.o) ? "0" : this.o).setWriteImagesInfo(this.f18358g.m()).send();
                        newInstance.setRichModeEnable(this.F);
                        this.f18357f.finish();
                        return;
                    } else if (this.v) {
                        x();
                        return;
                    } else {
                        n(null);
                        return;
                    }
                }
                return;
            }
            this.f18357f.showLoadingDialog("正在上传");
            new d(this, null).execute(new String[0]);
        }
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            c.a.p0.s4.k.a aVar = this.f18359h;
            if (aVar == null || aVar.l() == null || this.f18359h.l().Y0() == null) {
                return true;
            }
            return this.f18359h.l().Y0().getFirstVisiblePosition() == 0 && !this.f18359h.l().Y0().canScrollVertically(-1);
        }
        return invokeV.booleanValue;
    }

    public boolean j(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            this.f18358g.w(null);
            this.f18358g.c(imageFileInfo);
            K();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.f18357f.getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false) && this.f18358g.D() == (l = this.f18358g.l()) && l == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f18358g.g(), 0);
                    if (j(imageFileInfo)) {
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

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Intent intent = new Intent();
            String k = this.f18358g.k();
            if (TextUtils.isEmpty(k)) {
                k = "";
            }
            intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, k);
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            this.f18357f.setResult(0, intent);
            this.f18357f.finish();
        }
    }

    public void m(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, imageFileInfo) == null) || imageFileInfo == null) {
            return;
        }
        Intent intent = new Intent();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        linkedList.add(imageFileInfo);
        this.f18358g.m().setChosedFiles(linkedList);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.f18358g.m().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
        intent.putExtra("from_type", this.C);
        this.f18357f.setResult(-1, intent);
        this.f18357f.finish();
    }

    public final void n(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, intent) == null) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.f18358g.m().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            intent2.putExtra("from_type", this.C);
            if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
                intent2.putExtra("file_name", intent.getStringExtra("file_name"));
            }
            this.f18357f.setResult(-1, intent2);
            this.f18357f.finish();
            if (AlbumActivityConfig.FROM_FLUTTER.equals(this.m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921464, intent2));
            }
        }
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            c.a.p0.s4.k.c cVar = this.f18358g;
            if (cVar != null && ListUtils.getCount(cVar.g()) != 0) {
                for (int i = 0; i < ListUtils.getCount(this.f18358g.g()); i++) {
                    ImageFileInfo imageFileInfo = this.f18358g.g().get(i);
                    if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                        return i;
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
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            if (view == this.f18359h.h()) {
                i();
            } else if (view == this.f18359h.g()) {
                i();
            } else if (view == this.f18359h.d()) {
                c.a.p0.s4.k.c cVar = this.f18358g;
                if (cVar != null) {
                    cVar.A(null);
                }
                l();
            } else if (view == this.f18359h.c()) {
                P(0, this.a);
            } else if (view == this.f18359h.n()) {
                R(2);
            } else if (view == this.f18359h.m()) {
                R(1);
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f18355d = true;
            Q();
            this.f18357f.closeLoadingDialog();
            this.f18357f.dismissAllDialog();
            c.a.p0.s4.k.d.f().e();
            c.a.p0.s4.k.a aVar = this.f18359h;
            if (aVar != null) {
                aVar.p();
            }
            j jVar = this.j;
            if (jVar != null) {
                jVar.j();
            }
            Intent intent = new Intent();
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.f18358g.m().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            intent.putExtra("from_type", this.C);
            Intent intent2 = this.E;
            if (intent2 != null && !StringUtils.isNull(intent2.getStringExtra("file_name"))) {
                intent.putExtra("file_name", this.E.getStringExtra("file_name"));
            }
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            G();
            j jVar = this.j;
            if (jVar != null) {
                jVar.k();
            }
            this.f18356e = false;
        }
    }

    @Override // c.a.o0.x0.b
    public void onViewChangeSkinType(int i) {
        c.a.p0.s4.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048614, this, i) == null) || (aVar = this.f18359h) == null) {
            return;
        }
        aVar.onChangeSkinType(i);
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.q : invokeV.intValue;
    }

    public c.a.p0.s4.k.c q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f18358g : (c.a.p0.s4.k.c) invokeV.objValue;
    }

    public final void r(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, baseFragmentActivity, i, i2) == null) {
            this.f18357f = baseFragmentActivity;
            this.a = i;
            this.f18353b = i2;
            c.a.p0.s4.k.a aVar = new c.a.p0.s4.k.a(baseFragmentActivity.getPageContext(), this);
            this.f18359h = aVar;
            aVar.o();
        }
    }

    public final void s(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            this.f18358g = new c.a.p0.s4.k.c(this.f18357f.getPageContext());
            if (intent != null) {
                this.r = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
                this.s = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, false);
                this.t = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_GIF, true);
                if (this.r && this.s) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.f18358g.C(writeImagesInfo);
                this.f18358g.B(writeImagesInfo.isOriginalImg());
                this.x = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.p = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.m = intent.getStringExtra("from");
                this.o = intent.getStringExtra("forum_id");
                this.n = intent.getStringExtra("forum_name");
                this.q = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.y = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, true);
                this.z = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, false);
                this.u = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
                this.v = intent.getBooleanExtra(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.w = intent.getIntExtra(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                this.B = intent.getIntExtra(IntentConfig.KEY_FROM_WRITE_TYPE, 5);
                this.k = intent.getStringExtra("KEY_CALL_FROM");
                this.l = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
                this.C = intent.getIntExtra("from_type", 0);
                this.A = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
                this.D = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializableExtra = intent.getSerializableExtra("anti_data");
                if (serializableExtra instanceof AntiData) {
                    this.H = (AntiData) serializableExtra;
                }
                Serializable serializableExtra2 = intent.getSerializableExtra("prefix_data");
                if (serializableExtra2 instanceof PostPrefixData) {
                    this.G = (PostPrefixData) serializableExtra2;
                }
                this.I = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                this.J = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                this.F = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            h();
        }
    }

    public final void t(Bundle bundle) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            this.f18358g = new c.a.p0.s4.k.c(this.f18357f.getPageContext());
            if (bundle != null) {
                this.r = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
                this.s = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO);
                this.t = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_GIF);
                this.v = bundle.getBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.w = bundle.getInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                if (this.r && this.s) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.f18358g.C(writeImagesInfo);
                this.x = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.p = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.o = bundle.getString("forum_id");
                this.n = bundle.getString("forum_name");
                this.q = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.B = bundle.getInt(IntentConfig.KEY_FROM_WRITE_TYPE);
                this.y = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE);
                this.z = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE);
                this.k = bundle.getString("KEY_CALL_FROM");
                this.l = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
                this.C = bundle.getInt("from_type");
                this.A = (FrsTabInfoData) bundle.getSerializable("tab_list");
                this.m = bundle.getString("from");
                this.D = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializable = bundle.getSerializable("anti_data");
                if (serializable instanceof AntiData) {
                    this.H = (AntiData) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("prefix_data");
                if (serializable2 instanceof PostPrefixData) {
                    this.G = (PostPrefixData) serializable2;
                }
                this.I = bundle.getString(IntentConfig.FORUM_FIRST_DIR, "");
                this.J = bundle.getString(IntentConfig.FORUM_SECOND_DIR, "");
                this.F = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            h();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public final void x() {
        c.a.p0.s4.k.c cVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (cVar = this.f18358g) == null || (m = cVar.m()) == null || m.getChosedFiles() == null || m.getChosedFiles().size() < 1) {
            return;
        }
        boolean booleanExtra = this.f18357f.getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
        VideoCoverSelectActivityConfig videoCoverSelectActivityConfig = new VideoCoverSelectActivityConfig(this.f18357f);
        videoCoverSelectActivityConfig.setImagePath(m.getChosedFiles().getFirst().getFilePath());
        videoCoverSelectActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
        videoCoverSelectActivityConfig.setVideoType(this.w);
        this.f18357f.sendMessage(new CustomMessage(2002001, videoCoverSelectActivityConfig));
    }

    public final void y() {
        c.a.p0.s4.k.c cVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (cVar = this.f18358g) == null || (m = cVar.m()) == null) {
            return;
        }
        this.f18357f.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f18357f, 12012, m, o())));
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            c.a.p0.s4.k.c cVar = this.f18358g;
            if (cVar == null || ListUtils.getCount(cVar.g()) == 0) {
                return false;
            }
            int i = 0;
            for (ImageFileInfo imageFileInfo : this.f18358g.g()) {
                if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                    return false;
                }
            }
            return i == 1;
        }
        return invokeV.booleanValue;
    }
}
