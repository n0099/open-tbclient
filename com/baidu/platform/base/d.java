package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public SearchType f9729a;

    public abstract SearchResult a(String str);

    public SearchType a() {
        return this.f9729a;
    }

    public abstract void a(SearchResult searchResult, Object obj);

    public void a(SearchType searchType) {
        this.f9729a = searchType;
    }

    public boolean a(String str, SearchResult searchResult, boolean z) {
        SearchResult.ERRORNO errorno;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    int optInt = new JSONObject(str).optInt(z ? "status" : "status_sp");
                    if (optInt != 0) {
                        if (optInt != 200 && optInt != 230) {
                            switch (optInt) {
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                    errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                                    break;
                                default:
                                    errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                    break;
                            }
                        } else {
                            errorno = SearchResult.ERRORNO.KEY_ERROR;
                        }
                        searchResult.error = errorno;
                        return true;
                    }
                    return false;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return true;
            }
        }
        searchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return true;
    }
}
