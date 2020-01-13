package com.baidu.searchbox.ugc.lightbrowser;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.pyramid.runtime.service.a;
import com.baidu.searchbox.browser.ILightBrowser;
/* loaded from: classes12.dex */
public class LightBrowserServiceFetcher extends a<ILightBrowser> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.pyramid.runtime.service.a
    public ILightBrowser createService() throws ServiceNotFoundException {
        return new InvokeLightBrowser();
    }
}
