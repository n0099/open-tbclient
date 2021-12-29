package c.a.s0.s.z.s;

import android.text.TextUtils;
import c.a.s0.s.z.l;
import c.a.s0.s.z.n;
import c.a.s0.s.z.o;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public l f14050c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(l lVar) {
        super(lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14050c = lVar;
    }

    @Override // c.a.s0.s.z.n
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Image" : (String) invokeV.objValue;
    }

    @o(isAsync = false, value = "scanBigImages")
    public void sanBigImages(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("imageUrls");
        int optInt = jSONObject.optInt("clickIndex");
        int length = optJSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
            if (jSONObject2 != null) {
                String string = jSONObject2.getString("bigImageUrl");
                String string2 = jSONObject2.getString("originImageUrl");
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                    if (!TextUtils.isEmpty(string2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = string;
                        imageUrlData.originalUrl = string2;
                        concurrentHashMap.put(string, imageUrlData);
                    }
                }
            }
        }
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(optInt);
        bVar.C(true);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        c(new CustomMessage(2010000, bVar.v(this.f14050c.getContext())));
    }

    @o("selectPhotos")
    public void selectPhotos(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("selectPhotos")) != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(((JSONObject) optJSONArray.get(i2)).optString("filePath"));
                    linkedList.add(imageFileInfo);
                }
            }
            writeImagesInfo.setChosedFiles(linkedList);
            writeImagesInfo.setMaxImagesAllowed(9);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getContext(), writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 5);
            albumActivityConfig.setRequestCode(12015);
            c(new CustomMessage(2002001, albumActivityConfig));
        }
    }
}
