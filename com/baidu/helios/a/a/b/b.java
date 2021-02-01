package com.baidu.helios.a.a.b;
/* loaded from: classes6.dex */
class b extends com.baidu.helios.a.a.a.a {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:129:0x0194
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.helios.a.a.a.c
    public java.lang.String a(java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, org.json.JSONObject r11) {
        /*
            r7 = this;
            r4 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L10
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "urlStr should not be null"
            r0.<init>(r1)
            throw r0
        L10:
            r5 = 0
            java.lang.String r3 = ""
            java.net.URL r0 = new java.net.URL     // Catch: java.io.UnsupportedEncodingException -> L102 java.net.ProtocolException -> L122 java.io.IOException -> L142 java.lang.Throwable -> L162 java.net.MalformedURLException -> L1ab
            r0.<init>(r8)     // Catch: java.io.UnsupportedEncodingException -> L102 java.net.ProtocolException -> L122 java.io.IOException -> L142 java.lang.Throwable -> L162 java.net.MalformedURLException -> L1ab
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.io.UnsupportedEncodingException -> L102 java.net.ProtocolException -> L122 java.io.IOException -> L142 java.lang.Throwable -> L162 java.net.MalformedURLException -> L1ab
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.io.UnsupportedEncodingException -> L102 java.net.ProtocolException -> L122 java.io.IOException -> L142 java.lang.Throwable -> L162 java.net.MalformedURLException -> L1ab
            r1 = 15000(0x3a98, float:2.102E-41)
            r0.setConnectTimeout(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            r1 = 15000(0x3a98, float:2.102E-41)
            r0.setReadTimeout(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            r1 = 1
            r0.setDoOutput(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            r0.setRequestMethod(r9)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            if (r10 == 0) goto L73
            int r1 = r10.size()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            if (r1 <= 0) goto L73
            java.util.Set r1 = r10.keySet()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            java.util.Iterator r6 = r1.iterator()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
        L40:
            boolean r1 = r6.hasNext()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            if (r1 == 0) goto L6a
            java.lang.Object r1 = r6.next()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            java.lang.Object r2 = r10.get(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            r0.setRequestProperty(r1, r2)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            goto L40
        L56:
            r1 = move-exception
            r1 = r4
            r3 = r4
        L59:
            if (r0 == 0) goto L5e
            r0.disconnect()
        L5e:
            if (r1 == 0) goto L63
            r1.close()     // Catch: java.io.IOException -> Lf6
        L63:
            if (r3 == 0) goto L68
            r3.close()     // Catch: java.io.IOException -> Lfc
        L68:
            r1 = r4
        L69:
            return r1
        L6a:
            java.lang.String r1 = "Content-type"
            java.lang.String r2 = "application/json"
            r0.setRequestProperty(r1, r2)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
        L73:
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L181 java.io.IOException -> L18d java.net.ProtocolException -> L196 java.io.UnsupportedEncodingException -> L19f
            java.lang.String r1 = r11.toString()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            java.lang.String r6 = "utf-8"
            byte[] r1 = r1.getBytes(r6)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            r2.write(r1)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            r2.flush()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            r6 = 200(0xc8, float:2.8E-43)
            if (r1 != r6) goto Lda
            java.io.InputStream r1 = r0.getInputStream()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            java.lang.String r5 = "utf-8"
            r6.<init>(r1, r5)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L191 java.net.ProtocolException -> L19a java.io.UnsupportedEncodingException -> L1a4 java.net.MalformedURLException -> L1b1
            java.lang.String r1 = ""
            if (r5 == 0) goto L1bb
            r1 = r3
        La7:
            java.lang.String r3 = r5.readLine()     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> L18a
            if (r3 == 0) goto Lc0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> L18a
            r6.<init>()     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> L18a
            java.lang.StringBuilder r6 = r6.append(r1)     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> L18a
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> L18a
            java.lang.String r1 = r3.toString()     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> L18a
            goto La7
        Lbf:
            r3 = move-exception
        Lc0:
            if (r0 == 0) goto Lc5
            r0.disconnect()
        Lc5:
            if (r2 == 0) goto Lca
            r2.close()     // Catch: java.io.IOException -> Ld5
        Lca:
            if (r5 == 0) goto L69
            r5.close()     // Catch: java.io.IOException -> Ld0
            goto L69
        Ld0:
            r0 = move-exception
            r0.printStackTrace()
            goto L69
        Ld5:
            r0 = move-exception
            r0.printStackTrace()
            goto Lca
        Lda:
            if (r0 == 0) goto Ldf
            r0.disconnect()
        Ldf:
            if (r2 == 0) goto Le4
            r2.close()     // Catch: java.io.IOException -> Lec
        Le4:
            if (r4 == 0) goto Le9
            r5.close()     // Catch: java.io.IOException -> Lf1
        Le9:
            r1 = r4
            goto L69
        Lec:
            r0 = move-exception
            r0.printStackTrace()
            goto Le4
        Lf1:
            r0 = move-exception
            r0.printStackTrace()
            goto Le9
        Lf6:
            r0 = move-exception
            r0.printStackTrace()
            goto L63
        Lfc:
            r0 = move-exception
            r0.printStackTrace()
            goto L68
        L102:
            r0 = move-exception
            r2 = r4
            r5 = r4
            r0 = r4
        L106:
            if (r0 == 0) goto L10b
            r0.disconnect()
        L10b:
            if (r2 == 0) goto L110
            r2.close()     // Catch: java.io.IOException -> L118
        L110:
            if (r5 == 0) goto L115
            r5.close()     // Catch: java.io.IOException -> L11d
        L115:
            r1 = r4
            goto L69
        L118:
            r0 = move-exception
            r0.printStackTrace()
            goto L110
        L11d:
            r0 = move-exception
            r0.printStackTrace()
            goto L115
        L122:
            r0 = move-exception
            r2 = r4
            r5 = r4
            r0 = r4
        L126:
            if (r0 == 0) goto L12b
            r0.disconnect()
        L12b:
            if (r2 == 0) goto L130
            r2.close()     // Catch: java.io.IOException -> L138
        L130:
            if (r5 == 0) goto L135
            r5.close()     // Catch: java.io.IOException -> L13d
        L135:
            r1 = r4
            goto L69
        L138:
            r0 = move-exception
            r0.printStackTrace()
            goto L130
        L13d:
            r0 = move-exception
            r0.printStackTrace()
            goto L135
        L142:
            r0 = move-exception
            r2 = r4
            r5 = r4
            r0 = r4
        L146:
            if (r0 == 0) goto L14b
            r0.disconnect()
        L14b:
            if (r2 == 0) goto L150
            r2.close()     // Catch: java.io.IOException -> L158
        L150:
            if (r5 == 0) goto L155
            r5.close()     // Catch: java.io.IOException -> L15d
        L155:
            r1 = r4
            goto L69
        L158:
            r0 = move-exception
            r0.printStackTrace()
            goto L150
        L15d:
            r0 = move-exception
            r0.printStackTrace()
            goto L155
        L162:
            r0 = move-exception
            r1 = r0
            r2 = r4
            r5 = r4
            r3 = r4
        L167:
            if (r3 == 0) goto L16c
            r3.disconnect()
        L16c:
            if (r2 == 0) goto L171
            r2.close()     // Catch: java.io.IOException -> L177
        L171:
            if (r5 == 0) goto L176
            r5.close()     // Catch: java.io.IOException -> L17c
        L176:
            throw r1
        L177:
            r0 = move-exception
            r0.printStackTrace()
            goto L171
        L17c:
            r0 = move-exception
            r0.printStackTrace()
            goto L176
        L181:
            r1 = move-exception
            r2 = r4
            r5 = r4
            r3 = r0
            goto L167
        L186:
            r1 = move-exception
            r5 = r4
            r3 = r0
            goto L167
        L18a:
            r1 = move-exception
            r3 = r0
            goto L167
        L18d:
            r1 = move-exception
            r2 = r4
            r5 = r4
            goto L146
        L191:
            r1 = move-exception
            r5 = r4
            goto L146
        L194:
            r1 = move-exception
            goto L146
        L196:
            r1 = move-exception
            r2 = r4
            r5 = r4
            goto L126
        L19a:
            r1 = move-exception
            r5 = r4
            goto L126
        L19d:
            r1 = move-exception
            goto L126
        L19f:
            r1 = move-exception
            r2 = r4
            r5 = r4
            goto L106
        L1a4:
            r1 = move-exception
            r5 = r4
            goto L106
        L1a8:
            r1 = move-exception
            goto L106
        L1ab:
            r0 = move-exception
            r1 = r4
            r3 = r4
            r0 = r4
            goto L59
        L1b1:
            r1 = move-exception
            r1 = r2
            r3 = r4
            goto L59
        L1b6:
            r1 = move-exception
            r1 = r2
            r3 = r5
            goto L59
        L1bb:
            r1 = r3
            goto Lc0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.helios.a.a.b.b.a(java.lang.String, java.lang.String, java.util.Map, org.json.JSONObject):java.lang.String");
    }
}
