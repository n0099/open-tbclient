package c.a.r0.t.g;

import android.net.Uri;
import c.a.d.f.p.l;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0857b a;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<ShareItem, Integer, ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13887b;

        public a(b bVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13887b = bVar;
            this.a = shareItem;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ShareItem doInBackground(ShareItem... shareItemArr) {
            InterceptResult invokeL;
            ShareItem shareItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, shareItemArr)) == null) {
                String str = null;
                if (shareItemArr == null || shareItemArr.length < 1 || (shareItem = shareItemArr[0]) == null) {
                    return null;
                }
                String str2 = shareItem.K;
                NetWork netWork = new NetWork();
                netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_SHARE_IMAGE);
                if (shareItem.y == 4) {
                    netWork.addPostData("forum_id", this.a.J);
                    netWork.addPostData("type", "2");
                } else {
                    netWork.addPostData("thread_id", str2);
                    netWork.addPostData("type", "3");
                }
                String postNetData = netWork.postNetData();
                if (l.isEmpty(postNetData)) {
                    return shareItem;
                }
                try {
                    str = new JSONObject(postNetData).optString(BigdayActivityConfig.IMG_URL);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                if (shareItem.y != 4) {
                    shareItem.i0 = str;
                    shareItem.v = Uri.parse(str);
                }
                return shareItem;
            }
            return (ShareItem) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem) == null) {
                super.onPostExecute(shareItem);
                if (this.f13887b.a != null) {
                    this.f13887b.a.a(shareItem);
                }
            }
        }
    }

    /* renamed from: c.a.r0.t.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0857b {
        void a(ShareItem shareItem);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void b(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
            new a(this, shareItem).execute(shareItem);
        }
    }

    public void c(InterfaceC0857b interfaceC0857b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0857b) == null) {
            this.a = interfaceC0857b;
        }
    }
}
