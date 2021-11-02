package b.a.r0.d4.p;

import android.location.Address;
import b.a.e.e.p.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15990a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f15991b;

    /* renamed from: c  reason: collision with root package name */
    public e f15992c;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<c, Integer, d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f15993a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15993a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d doInBackground(c... cVarArr) {
            InterceptResult invokeL;
            c cVar;
            ImageUploadResult.picInfo picinfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                String str = null;
                if (cVarArr.length == 0 || (cVar = cVarArr[0]) == null) {
                    return null;
                }
                b.a.e.e.a.f.c cVar2 = new b.a.e.e.a.f.c("images", TbMd5.getNameMd5FromUrl(cVar.f15986i + 42), DiskFileOperate.Action.READ);
                cVar2.setSubFolder(true);
                cVar2.setIsFormatData(false);
                ImageUploadResult m = new b.a.q0.d0.f(null).m(c(cVar2.buildPath(), cVar2.getName()), true, false);
                if (m != null && (picinfo = m.picInfo) != null) {
                    ImageUploadResult.PicDetailedInfo picDetailedInfo = picinfo.originPic;
                    if (picDetailedInfo != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                        str = m.picInfo.originPic.picUrl;
                    } else {
                        ImageUploadResult.PicDetailedInfo picDetailedInfo2 = m.picInfo.bigPic;
                        if (picDetailedInfo2 != null && !StringUtils.isNull(picDetailedInfo2.picUrl)) {
                            str = m.picInfo.bigPic.picUrl;
                        } else {
                            ImageUploadResult.PicDetailedInfo picDetailedInfo3 = m.picInfo.smallPic;
                            if (picDetailedInfo3 != null && !StringUtils.isNull(picDetailedInfo3.picUrl)) {
                                str = m.picInfo.smallPic.picUrl;
                            }
                        }
                    }
                }
                if (StringUtils.isNull(str)) {
                    str = cVar.j;
                }
                NetWork netWork = new NetWork();
                netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                netWork.addPostData("anonymous", "1");
                netWork.addPostData("can_no_forum", "0");
                netWork.addPostData("is_feedback", "0");
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    netWork.addPostData("vcode_tag", "12");
                }
                netWork.addPostData("new_vcode", "1");
                netWork.addPostData("content", cVar.m);
                netWork.addPostData("fid", cVar.f15982e);
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, cVar.f15983f);
                netWork.addPostData("is_hide", "0");
                netWork.addPostData(IntentConfig.CALL_FROM, "2");
                netWork.addPostData("title", cVar.m);
                netWork.addPostData("is_ntitle", "1");
                netWork.addPostData("st_type", "notitle");
                netWork.addPostData("is_location", "2");
                Address j = b.a.e.e.i.a.n().j(false);
                if (j != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.f15982e)) {
                    netWork.addPostData("lbs", String.valueOf(j.getLatitude()) + "," + String.valueOf(j.getLongitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(j.getLatitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(j.getLongitude()));
                }
                LocationData b2 = b.a.r0.l3.o0.b.a().b();
                if (b2 != null) {
                    netWork.addPostData("name", b2.getFormatted_address());
                    netWork.addPostData("sn", b2.getSn());
                }
                netWork.addPostData("is_link_thread", "0");
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    netWork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                netWork.addPostData("tbopen_app_key", cVar.f15978a);
                netWork.addPostData("tbopen_app_icon", cVar.f15981d);
                netWork.addPostData("tbopen_app_name", cVar.f15980c);
                netWork.addPostData("share_abstract", cVar.f15985h);
                netWork.addPostData("share_image", str);
                netWork.addPostData("share_h5_url", cVar.k);
                netWork.addPostData("share_swan_app_key", cVar.f15979b);
                netWork.addPostData("share_swan_path", cVar.l);
                String postNetData = netWork.postNetData();
                d dVar = new d();
                try {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    jSONObject.optString("msg");
                    jSONObject.optString("pre_msg");
                    dVar.f15988b = cVar.f15982e;
                    dVar.f15989c = jSONObject.optString("tid");
                    jSONObject.optString("pid");
                    jSONObject.optString("video_id");
                } catch (Exception unused) {
                }
                ErrorData errorData = new ErrorData();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    errorData.parserJson(postNetData);
                } else {
                    errorData.setError_code(netWork.isNetSuccess() ? netWork.getServerErrorCode() : netWork.getNetErrorCode());
                    errorData.setError_msg(netWork.getErrorString());
                }
                if (errorData.error_code != 0 && !j.z()) {
                    errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
                }
                dVar.f15987a = errorData;
                try {
                    new AntiData().parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
                } catch (Exception unused2) {
                }
                return dVar;
            }
            return (d) invokeL.objValue;
        }

        public String c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                String str3 = this.f15993a.f15990a + str2;
                if (str != null) {
                    return this.f15993a.f15990a + str + "/" + str2;
                }
                return str3;
            }
            return (String) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || this.f15993a.f15992c == null) {
                return;
            }
            this.f15993a.f15992c.a(dVar);
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    public f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15990a = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        this.f15991b = bdUniqueId;
    }

    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f15992c = eVar;
        }
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            b bVar = new b(this, null);
            bVar.setTag(this.f15991b);
            bVar.execute(cVar);
        }
    }
}
