package com.baidu.ar.recommend;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.parser.ParserJson;
import com.baidu.ar.recommend.h;
import com.baidu.ar.task.HttpTaskUtility;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ArResourceUtils;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.UrlUtils;
import com.baidu.ar.util.ZipUtils;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends AsyncTask<Void, Void, List<ARResource>> {
    private Context a;
    private ARResource b;
    private h.a c;

    public i(Context context, ARResource aRResource, h.a aVar) {
        this.a = context;
        this.b = aRResource;
        this.c = aVar;
    }

    private List<ARResource> a(String str) {
        List<ARResource> list;
        JSONException jSONException;
        try {
            List<ARResource> parseRecommendList = ParserJson.parseRecommendList(new JSONObject(str));
            if (parseRecommendList != null) {
                try {
                    if (parseRecommendList.size() > 0) {
                        for (ARResource aRResource : parseRecommendList) {
                            a(aRResource);
                        }
                    }
                } catch (JSONException e) {
                    list = parseRecommendList;
                    jSONException = e;
                    jSONException.printStackTrace();
                    return list;
                }
            }
            return parseRecommendList;
        } catch (JSONException e2) {
            list = null;
            jSONException = e2;
        }
    }

    private void a() {
        this.a = null;
        this.c = null;
    }

    private void a(ARResource aRResource) {
        String key = aRResource.getKey();
        String versionCode = aRResource.getVersionCode();
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(versionCode)) {
            return;
        }
        String aRCaseMainZipFullPath = ARFileUtils.getARCaseMainZipFullPath(aRResource.getKey(), aRResource.getVersionCode());
        if (new File(aRCaseMainZipFullPath).exists()) {
            if (ZipUtils.isZipFile(aRCaseMainZipFullPath)) {
                String aRCaseDirPath = ARFileUtils.getARCaseDirPath(aRResource.getKey());
                aRResource.setZipFilePath(aRCaseMainZipFullPath);
                aRResource.setResFilePath(aRCaseDirPath);
                aRResource.setCaseConfigJsonInfo(ArResourceUtils.generateResult(aRCaseDirPath));
                aRResource.setDownloadStatus(-2);
            } else {
                FileUtils.deleteFileIfExist(new File(aRCaseMainZipFullPath));
            }
        }
        aRResource.setFunctionMap(this.b.getFunctionMap());
        aRResource.setHardwareSatisfied(this.b.isHardwareSatisfied());
        aRResource.setRedirectUrl(this.b.getRedirectUrl());
        aRResource.setCodeDownloadUrl(this.b.getCodeDownloadUrl());
        aRResource.setRefused(this.b.isRefused());
        aRResource.setShowAudioDialog(this.b.isShowAudioDialog());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<ARResource> doInBackground(Void... voidArr) {
        String postRequest = HttpUtils.postRequest(UrlUtils.getRecommendUrl(), HttpTaskUtility.getHttpParamsWithKey(this.a, this.b.getKey()));
        if (TextUtils.isEmpty(postRequest)) {
            return null;
        }
        return a(postRequest);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(List<ARResource> list) {
        super.onPostExecute(list);
        if (this.c != null) {
            this.c.a(list);
        }
        a();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        a();
    }
}
